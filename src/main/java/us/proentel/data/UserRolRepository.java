package us.proentel.data;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;
import us.proentel.domain.Rol;
import us.proentel.domain.UserRol;
import us.proentel.dto.RolDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserRolRepository {

    private final DataSource ds;

    public UserRolRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<UserRol> getByUserId(String Id) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_security.user_rol WHERE user_id = '" + Id + "';";
            Optional<UserRol> userRol = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new UserRol.Builder()
                            .setId(rs.getString(1))
                            .setUserId(rs.getString(2))
                            .setRolId(rs.getString(3))
                            .setIsactive(rs.getString(4))
                            .setCreateBy(rs.getString(5))
                            .setUpdateBy(rs.getString(6))
                            .setCreateDate(rs.getString(7))
                            .setUpdateDate(rs.getString(8))
                            .build());
                });
            return userRol;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Rol> getRolByName(String name) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_security.rol WHERE name = '" + name + "';";
            Optional<Rol> rol = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new Rol.Builder()
                                .setId(rs.getString(1))
                                .setName(rs.getString(2))
                                .setIsactive(rs.getString(3))
                                .setCreateBy(rs.getString(4))
                                .setUpdateBy(rs.getString(5))
                                .setCreateDate(rs.getString(6))
                                .setUpdateDate(rs.getString(7))
                                .build());
                    });
            return rol;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



   public List<Rol> getRol() {
        QueryRunner run = new QueryRunner(ds);
        List<Rol> rol = new LinkedList<>();
        try {
            String query = "SELECT * FROM proentel_security.rol";
            List<Rol> rolList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            rol.add(new Rol.Builder()
                                    .setId(rs.getString(1))
                                    .setName(rs.getString(2))
                                    .setIsactive(rs.getString(3))
                                    .setCreateBy(rs.getString(4))
                                    .setUpdateBy(rs.getString(5))
                                    .setCreateDate(rs.getString(6))
                                    .setUpdateDate(rs.getString(7))
                                    .build());
                        }
                        return rol;
                    });
            return rolList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createRol(RolDto rol) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String Id = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {
                String insert = "INSERT INTO proentel_security.rol " +
                        "(id, " +
                        "name, " +
                        "create_by, " +
                        "update_by) " +
                        "VALUES " +
                        "('" + Id + "', " +
                        "'" + rol.getName() + "', " +
                        "'" + rol.getCreateBy() + "', " +
                        "'" + rol.getUpdateBy() +  "');";
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

        return Id;
    }

    public void updateRol(Rol rol) {
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            try {
                String update = "UPDATE proentel_security.rol " +
                        "SET name = '" + rol.getName() + "', "+
                        "isactive = '" + rol.getIsactive() + "', "+
                        "update_by = '" + rol.getUpdateBy() + "', "+
                        "update_date = NOW()"+
                        "WHERE " +
                        "id = '" + rol.getId() + "';";
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
}
