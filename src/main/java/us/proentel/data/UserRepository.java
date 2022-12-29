package us.proentel.data;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;
import us.proentel.domain.User;
import us.proentel.dto.UserDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepository {

    private final DataSource ds;

    public UserRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<User> getUserById(String Id) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_security.user WHERE id = '" + Id + "';";
            Optional<User> user = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new User.Builder()
                            .setId(rs.getString(1))
                            .setEmail(rs.getString(2))
                            .setName(rs.getString(3))
                            .setUsername(rs.getString(4))
                            .setPassword(rs.getString(5))
                            .setIsactive(rs.getString(6))
                            .setCreateBy(rs.getString(7))
                            .setUpdateBy(rs.getString(8))
                            .setCreateDate(rs.getString(9))
                            .setUpdateDate(rs.getString(10))
                            .build());
                });
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> getUserByUserName(String username) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_security.user WHERE username = '" + username + "';";
            Optional<User> user = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new User.Builder()
                                .setId(rs.getString(1))
                                .setEmail(rs.getString(2))
                                .setName(rs.getString(3))
                                .setUsername(rs.getString(4))
                                .setPassword(rs.getString(5))
                                .setIsactive(rs.getString(6))
                                .setCreateBy(rs.getString(7))
                                .setUpdateBy(rs.getString(8))
                                .setCreateDate(rs.getString(9))
                                .setUpdateDate(rs.getString(10))
                                .build());
                    });
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> getUserByEmail(String email) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_security.user WHERE email = '" + email + "';";
            Optional<User> user = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new User.Builder()
                                .setId(rs.getString(1))
                                .setEmail(rs.getString(2))
                                .setName(rs.getString(3))
                                .setUsername(rs.getString(4))
                                .setPassword(rs.getString(5))
                                .setIsactive(rs.getString(6))
                                .setCreateBy(rs.getString(7))
                                .setUpdateBy(rs.getString(8))
                                .setCreateDate(rs.getString(9))
                                .setUpdateDate(rs.getString(10))
                                .build());
                    });
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public List<User> getCities() {
        QueryRunner run = new QueryRunner(ds);
        List<User> user = new LinkedList<>();
        try {
            String query = "SELECT * FROM proentel_security.user";
            List<User> userList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            user.add(new User.Builder()
                                    .setId(rs.getString(1))
                                    .setEmail(rs.getString(2))
                                    .setName(rs.getString(3))
                                    .setUsername(rs.getString(4))
                                    .setPassword(rs.getString(5))
                                    .setIsactive(rs.getString(6))
                                    .setCreateBy(rs.getString(7))
                                    .setUpdateBy(rs.getString(8))
                                    .setCreateDate(rs.getString(9))
                                    .setUpdateDate(rs.getString(10))
                                    .build());
                        }
                        return user;
                    });
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createUser(UserDto user) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String Id = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {
                String insert = "INSERT INTO proentel_security.user " +
                        "(id, " +
                        "email, " +
                        "name, " +
                        "username, " +
                        "password, " +
                        "create_by, " +
                        "update_by) " +
                        "VALUES " +
                        "('" + Id + "', " +
                        "'" + user.getEmail() + "', " +
                        "'" + user.getName() + "', " +
                        "'" + user.getUsername() + "', " +
                        "'" + user.getPassword() + "', " +
                        "'" + user.getCreateBy() + "', " +
                        "'" + user.getUpdateBy() +  "');";
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

    public void updateUser(User user) {
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            try {
                String update = "UPDATE proentel_security.user " +
                        "SET email = '" + user.getEmail() + "', "+
                        "name = '" + user.getName() + "', "+
                        "username = '" + user.getUsername() + "', "+
                        "isactive = '" + user.getIsactive() + "', "+
                        "update_by = '" + user.getUpdateBy() + "', "+
                        "update_date = NOW()"+
                        "WHERE " +
                        "id = '" + user.getId() + "';";
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
