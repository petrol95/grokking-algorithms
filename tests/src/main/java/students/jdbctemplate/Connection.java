package students.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Connection {

    JdbcTemplate jdbcTemplate;

    public Connection(String dbName) {
        DriverManagerDataSource dataSource = new SingleConnectionDataSource
                ("jdbc:sqlite:" + dbName, true);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
