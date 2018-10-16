package co.ppk.data;

import co.ppk.domain.Operator;
import co.ppk.dto.OperatorDto;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Optional<Operator> getBillboardById(String billboardId) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_transactions.billboards WHERE id = '" + billboardId + "';";
            Optional<Operator> billboard = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new Operator.Builder()
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

    public List<Operator> getBillboard() {
        QueryRunner run = new QueryRunner(ds);
        List<Operator> operator = new LinkedList<>();
        try {
            String query = "SELECT * FROM ppk_transactions.billboards;";
            List<Operator> operatorList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            operator.add(new Operator.Builder()
                                    .setId(rs.getString(1))
                                    .setCode(rs.getString(2))
                                    .setAddress(rs.getString(3))
                                    .setCreateDate(rs.getString(4))
                                    .setUpdateDate(rs.getString(5))
                                    .build());
                        }
                        return operator;
                    });
            return operatorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createBillboard(OperatorDto billboard) {
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
                        "address) " +
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



    public Optional<Operator> getBillboardByCode(String code) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_transactions.billboards WHERE code = '" + code + "';";
            Optional<Operator> Billboard = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new Operator.Builder()
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

    public void updateBillboard(Operator operator) {
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            try {
                String update = "UPDATE ppk_transactions.billboards " +
                        "SET code = '" + operator.getCode() + "', "+
                        "address = '" + operator.getAddress() + "' "+
                        "WHERE " +
                        "id = '" + operator.getId() + "';";
                stmt.executeUpdate(update);
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
    }

    public void deleteBillboard(String billboardId) {
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            try {
                String delete = "DELETE FROM ppk_transactions.billboards " +
                        "WHERE " +
                        "id = '" + billboardId + "';";
                stmt.execute(delete);
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
    }
}
