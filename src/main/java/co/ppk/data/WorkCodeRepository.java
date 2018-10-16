package co.ppk.data;

import co.ppk.domain.WorkCodes;
import co.ppk.dto.WorkCodeDto;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RateRepository {

    private final DataSource ds;

    public RateRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<WorkCodes> getRate() {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_transactions.rates WHERE status = 'A';";
            Optional<WorkCodes> rate = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new WorkCodes.Builder()
                            .setId(rs.getString(1))
                            .setDate(rs.getString(2))
                            .setValue(rs.getString(3))
                            .setStatus(rs.getString(4))
                            .setCreateDate(rs.getString(5))
                            .setUpdateDate(rs.getString(6))
                            .build());
                });
            return rate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WorkCodes> getRates() {
        QueryRunner run = new QueryRunner(ds);
        List<WorkCodes> workCodes = new LinkedList<>();
        try {
            String query = "SELECT * FROM ppk_transactions.rates;";
            List<WorkCodes> workCodesList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            workCodes.add(new WorkCodes.Builder()
                                    .setId(rs.getString(1))
                                    .setDate(rs.getString(2))
                                    .setValue(rs.getString(3))
                                    .setStatus(rs.getString(4))
                                    .setCreateDate(rs.getString(5))
                                    .setUpdateDate(rs.getString(6))
                                    .build());
                        }
                        return workCodes;
                    });
            return workCodesList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createRate(WorkCodeDto rate) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String rateId = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {

                String insert = "INSERT INTO ppk_transactions.rates " +
                        "(id, " +
                        "date, " +
                        "value, " +
                        "status) " +
                        "VALUES " +
                        "('" + rateId + "', " +
                        "'" + rate.getDate() + "', " +
                        "'" + rate.getValue() + "', " +
                        "'" + rate.getStatus() + "');";
                run.insert(conn, insert, new ScalarHandler<>());
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            } finally {
                DbUtils.close(conn);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rateId;
    }




}
