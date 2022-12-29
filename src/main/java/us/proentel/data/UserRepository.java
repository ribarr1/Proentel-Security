package us.proentel.data;

import us.proentel.domain.City;
import us.proentel.domain.City;
import us.proentel.dto.CityDto;
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
public class CityRepository {

    private final DataSource ds;

    public CityRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<City> getCityById(String Id) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_geography.cities WHERE id = '" + Id + "';";
            Optional<City> city = run.query(query,
                rs -> {
                    if (!rs.next()) {
                        Optional<Object> empty = Optional.empty();
                        return Optional.empty();
                    }
                    rs.last();
                    return Optional.ofNullable(new City.Builder()
                            .setId(rs.getString(1))
                            .setCode(rs.getString(2))
                            .setName(rs.getString(3))
                            .setCode_state(rs.getString(4))
                            .setIsactive(rs.getString(5))
                            .setCreateBy(rs.getString(6))
                            .setUpdateBy(rs.getString(7))
                            .setCreateDate(rs.getString(8))
                            .setUpdateDate(rs.getString(9))
                            .build());
                });
            return city;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<City> getCityByCode(String code) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM proentel_geography.cities WHERE code = '" + code + "';";
            Optional<City> city = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new City.Builder()
                                .setId(rs.getString(1))
                                .setCode(rs.getString(2))
                                .setName(rs.getString(3))
                                .setCode_state(rs.getString(4))
                                .setIsactive(rs.getString(5))
                                .setCreateBy(rs.getString(6))
                                .setUpdateBy(rs.getString(7))
                                .setCreateDate(rs.getString(8))
                                .setUpdateDate(rs.getString(9))
                                .build());
                    });
            return city;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public List<City> getCities() {
        QueryRunner run = new QueryRunner(ds);
        List<City> cities = new LinkedList<>();
        try {
            String query = "SELECT * FROM proentel_geography.cities";
            List<City> cityList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            cities.add(new City.Builder()
                                    .setId(rs.getString(1))
                                    .setCode(rs.getString(2))
                                    .setName(rs.getString(3))
                                    .setCode_state(rs.getString(4))
                                    .setIsactive(rs.getString(5))
                                    .setCreateBy(rs.getString(6))
                                    .setUpdateBy(rs.getString(7))
                                    .setCreateDate(rs.getString(8))
                                    .setUpdateDate(rs.getString(9))
                                    .build());
                        }
                        return cities;
                    });
            return cityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createCity(CityDto city) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String Id = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {
                String insert = "INSERT INTO proentel_geography.cities " +
                        "(id, " +
                        "code, " +
                        "name, " +
                        "code_state, " +
                        "create_by, " +
                        "update_by) " +
                        "VALUES " +
                        "('" + Id + "', " +
                        "'" + city.getCode() + "', " +
                        "'" + city.getName() + "', " +
                        "'" + city.getCode_state() + "', " +
                        "'" + city.getCreateBy() + "', " +
                        "'" + city.getUpdateBy() +  "');";
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

    public void updateCity(City city) {
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            try {
                String update = "UPDATE proentel_geography.cities " +
                        "SET code = '" + city.getCode() + "', "+
                        "name = '" + city.getName() + "', "+
                        "code_state = '" + city.getCode_state() + "', "+
                        "isactive = '" + city.getIsactive() + "', "+
                        "update_by = '" + city.getUpdateBy() + "', "+
                        "update_date = NOW()"+
                        "WHERE " +
                        "id = '" + city.getId() + "';";
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
