package fr.diginamic.props;

import java.util.ResourceBundle;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * TestConfigurationProps
 */
public class TestConfigurationProps {

    public static void main(String[] args) {
        ResourceBundle configProperties = ResourceBundle.getBundle("config");
        System.out.println(configProperties.getString("database.url"));

        Configurations config = new Configurations();
        try {
            Configuration properties = config.properties("config.properties");

            System.out.println("With apache:");
            System.out.println(properties.getString("database.url"));

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }
}