package co.ppk.data;

import co.ppk.domain.Billboard;
import co.ppk.domain.Rate;
import co.ppk.dto.BillboardDto;
import co.ppk.dto.RateDto;
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

    public Optional<Rate> getRate(String Rate) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM transactions.rate WHERE status = 'A';";
            Optional<Rate> rate = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new Rate.Builder()
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

    public List<Rate> getRates() {
        QueryRunner run = new QueryRunner(ds);
        List<Rate> rate = new LinkedList<>();
        try {
            String query = "SELECT * FROM transactions.rate;";
            List<Rate> rateList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            rate.add(new Rate.Builder()
                                    .setId(rs.getString(1))
                                    .setDate(rs.getString(2))
                                    .setValue(rs.getString(3))
                                    .setStatus(rs.getString(4))
                                    .setCreateDate(rs.getString(5))
                                    .setUpdateDate(rs.getString(6))
                                    .build());
                        }
                        return rate;
                    });
            return rateList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createRate(RateDto rate) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String rateId = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {

                String insert = "INSERT INTO transactions.rate " +
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
