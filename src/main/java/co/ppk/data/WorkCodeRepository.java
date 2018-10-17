package co.ppk.data;

import co.ppk.domain.WorkCode;
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
public class WorkCodeRepository {

    private final DataSource ds;

    public WorkCodeRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<WorkCode> getWorkCodeByAuthorizationCode(String authorizationCode) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_transactions.work_codes WHERE authorization_code = "+ authorizationCode;
            Optional<WorkCode> workCode = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new WorkCode.Builder()
                            .setId(rs.getString(1))
                            .setOperatorId(rs.getString(2))
                            .setBillaboardId(rs.getString(3))
                            .setAuthorization_code(rs.getString(4))
                            .setStatus(rs.getString(5))
                            .setCreateDate(rs.getString(6))
                            .setUpdateDate(rs.getString(7))
                            .build());
                });
            return workCode;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WorkCode> getWorkCode() {
        QueryRunner run = new QueryRunner(ds);
        List<WorkCode> workCodes = new LinkedList<>();
        try {
            String query = "SELECT * FROM ppk_transactions.work_codes;";
            List<WorkCode> workCodeList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            workCodes.add(new WorkCode.Builder()
                                    .setId(rs.getString(1))
                                    .setOperatorId(rs.getString(2))
                                    .setBillaboardId(rs.getString(3))
                                    .setAuthorization_code(rs.getString(4))
                                    .setStatus(rs.getString(5))
                                    .setCreateDate(rs.getString(6))
                                    .setUpdateDate(rs.getString(7))
                                    .build());
                        }
                        return workCodes;
                    });
            return workCodeList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createWorkCode(WorkCodeDto workCode) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());
        //por ahora
        String ahora = "";
        String workCodeId = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {

                String insert = "INSERT INTO ppk_transactions.work_codes " +
                        "(id, " +
                        "operatorId, " +
                        "billaboardId, " +
                        "authorization_code, " +
                        "status) " +
                        "VALUES " +
                        "('" + workCodeId + "', " +
                        "'" + workCode.getOperatorId() + "', " +
                        "'" + workCode.getBillaboardId() + "', " +
                        "'" + workCode.getAuthorization_code() + "', " +
                        "'" + workCode.getStatus() + "');";
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

        return workCodeId;
    }




}
