package co.ppk.data;

import co.ppk.domain.Billboard;
import co.ppk.dto.BillboardDto;
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
public class BillboardRepository {

    private final DataSource ds;

    public BillboardRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<Billboard> getBillboard(String Code) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_transactions.billboards WHERE code = '" + Code + "';";
            Optional<Billboard> billboard = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new Billboard.Builder()
                            .setId(rs.getString(1))
                            .setCode(rs.getString(2))
                            .setAddress(rs.getString(3))
                            .setCreateDate(rs.getString(4))
                            .setUpdateDate(rs.getString(5))
                            .build());
                });
            return billboard;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Billboard> getBillboard() {
        QueryRunner run = new QueryRunner(ds);
        List<Billboard> billboard = new LinkedList<>();
        try {
            String query = "SELECT * FROM ppk_transactions.billboards;";
            List<Billboard> billboardList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            billboard.add(new Billboard.Builder()
                                    .setId(rs.getString(1))
                                    .setCode(rs.getString(2))
                                    .setAddress(rs.getString(3))
                                    .setCreateDate(rs.getString(4))
                                    .setUpdateDate(rs.getString(5))
                                    .build());
                        }
                        return billboard;
                    });
            return billboardList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createBillboard(BillboardDto billboard) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String billboardId = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {

                String insert = "INSERT INTO ppk_transactions.billboards " +
                        "(id, " +
                        "code, " +
                        "address, " +
                        "VALUES " +
                        "('" + billboardId + "', " +
                        "'" + billboard.getCode() + "', " +
                        "'" + billboard.getAddress() + "');";
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

        return billboardId;
    }



    public Optional<Billboard> getBillboardByCode(String code) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_transactions.billboards WHERE code = '" + code + "';";
            Optional<Billboard> Billboard = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new Billboard.Builder()
                                .setId(rs.getString(1))
                                .setCode(rs.getString(2))
                                .setAddress(rs.getString(3))
                                .setCreateDate(rs.getString(4))
                                .setUpdateDate(rs.getString(5))
                                .build());
                    });
            return Billboard;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
