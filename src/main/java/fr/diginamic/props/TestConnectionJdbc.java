package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class TestConnectionJdbc {

    public static void main(String[] args) {
        StringBuilder connectionString = new StringBuilder();

        Configurations config = new Configurations();
        try {
            Configuration properties = config.properties("config.properties");

            System.out.println("With apache:");
            String dbUrl = properties.getString("database.url");
            String user = properties.getString("database.user");
            String pass = properties.getString("database.password");

            connectionString.append(dbUrl);
            connectionString.append("?user=");
            connectionString.append(user);
            connectionString.append("&password=");
            connectionString.append(pass);
            // connectionString.append("&ssl=true");

            try {
                Connection conn = DriverManager.getConnection(connectionString.toString());

                System.out.println(conn.getSchema());
            } catch (SQLException e) {
                e.printStackTrace();

            }

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }
}
