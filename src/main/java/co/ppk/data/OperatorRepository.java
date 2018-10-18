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
public class OperatorRepository {

    private final DataSource ds;

    public OperatorRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<Operator> getOperatorById(String operatorId) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_operators.operators WHERE id = '" + operatorId + "';";
            Optional<Operator> operator = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new Operator.Builder()
                            .setId(rs.getString(1))
                            .setDocument_type(rs.getString(2))
                            .setDocument_number(rs.getString(3))
                            .setName(rs.getString(4))
                            .setLast_name(rs.getString(5))
                            .setAddress(rs.getString(6))
                            .setPersonal_phone(rs.getString(7))
                            .setAssigned_phone(rs.getString(8))
                            .setStatus(rs.getString(9))
                            .setCreateDate(rs.getString(10))
                            .setUpdateDate(rs.getString(11))
                            .build());
                });
            return operator;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Operator> getOperatorByDocument(String documentType, String documentNumber) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_operators.operators WHERE document_type = '" + documentType + "'" +
                            " AND document_number = '"+documentNumber+"';";
            Optional<Operator> operator = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new Operator.Builder()
                                .setId(rs.getString(1))
                                .setDocument_type(rs.getString(2))
                                .setDocument_number(rs.getString(3))
                                .setName(rs.getString(4))
                                .setLast_name(rs.getString(5))
                                .setAddress(rs.getString(6))
                                .setPersonal_phone(rs.getString(7))
                                .setAssigned_phone(rs.getString(8))
                                .setStatus(rs.getString(9))
                                .setCreateDate(rs.getString(10))
                                .setUpdateDate(rs.getString(11))
                                .build());
                    });
            return operator;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Operator> getOperator() {
        QueryRunner run = new QueryRunner(ds);
        List<Operator> operator = new LinkedList<>();
        try {
            String query = "SELECT * FROM ppk_operators.operators;";
            List<Operator> operatorList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            operator.add(new Operator.Builder()
                                    .setId(rs.getString(1))
                                    .setDocument_type(rs.getString(2))
                                    .setDocument_number(rs.getString(3))
                                    .setName(rs.getString(4))
                                    .setLast_name(rs.getString(5))
                                    .setAddress(rs.getString(6))
                                    .setPersonal_phone(rs.getString(7))
                                    .setAssigned_phone(rs.getString(8))
                                    .setStatus(rs.getString(9))
                                    .setCreateDate(rs.getString(10))
                                    .setUpdateDate(rs.getString(11))
                                    .build());
                        }
                        return operator;
                    });
            return operatorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createOperator(OperatorDto operator) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String operatorId = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {
                String insert = "INSERT INTO ppk_operators.operators " +
                        "(id, " +
                        "document_type, " +
                        "document_number, " +
                        "name, " +
                        "last_name, " +
                        "address, " +
                        "personal_phone, " +
                        "assigned_phone, " +
                        "status) " +
                        "VALUES " +
                        "('" + operatorId + "', " +
                        "'" + operator.getDocument_type() + "', " +
                        "'" + operator.getDocument_number() + "', " +
                        "'" + operator.getName() + "', " +
                        "'" + operator.getLast_name() + "', " +
                        "'" + operator.getAddress() + "', " +
                        "'" + operator.getPersonal_phone() + "', " +
                        "'" + operator.getAssigned_phone() + "', " +
                        "'" + operator.getStatus() + "');";
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

        return operatorId;
    }
}
