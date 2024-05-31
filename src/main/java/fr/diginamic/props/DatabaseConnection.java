package fr.diginamic.props;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.postgresql.ds.PGConnectionPoolDataSource;

public class DatabaseConnection {
    private String url = null;
    private static DatabaseConnection instance = null;
    private PGConnectionPoolDataSource dataSource;

    public DatabaseConnection() {
        Configurations config = new Configurations();

        try {
            Configuration properties = config.properties("config.properties");

            System.out.println("With apache:");
            String dbUrl = properties.getString("database.url");
            String user = properties.getString("database.user");
            String pass = properties.getString("database.password");

            String connectionString = String.format("%s?user=%s&password=%s", dbUrl, user, pass);

            url = connectionString.toString();

            dataSource = new PGConnectionPoolDataSource();
            dataSource.setUrl(this.url);
            dataSource.setDefaultAutoCommit(false);

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
