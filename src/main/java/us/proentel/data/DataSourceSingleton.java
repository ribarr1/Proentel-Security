package co.ppk.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;

@Component
public class DataSourceSingleton {

    private static DataSource instance = null;

    public DataSourceSingleton() {}

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            config.setJdbcUrl(Optional.ofNullable(System.getenv("MATERIAL_DB_URL"))
                    .orElse("jdbc:mysql://localhost:3306/proentel_material?useSSL=false"));
                     // .orElse("jdbc:mysql://127.0.0.1:3306/ppk_operators"));
            config.setUsername(Optional.ofNullable(System.getenv("MATERIAL_JDBC_USERNAME"))
                    .orElse("root"));
            config.setPassword(Optional.ofNullable(System.getenv("MATERIAL_JDBC_PASSWORD"))
                    .orElse(""));
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("characterEncoding", "UTF-8");
            config.addDataSourceProperty("useUnicode", "true");
            config.addDataSourceProperty("serverTimezone", "UTC");

            instance = new HikariDataSource(config);

            Flyway flyway = new Flyway();
            flyway.setDataSource(instance);
            flyway.setLocations("classpath:db/migration/transaction");
            flyway.migrate();
        }
        return instance;
    }
}

