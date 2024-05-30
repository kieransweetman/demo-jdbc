package fr.diginamic.props;

import java.util.ResourceBundle;

/**
 * TestConfigurationProps
 */
public class TestConfigurationProps {

    public static void main(String[] args) {
        ResourceBundle configProperties = ResourceBundle.getBundle("config");

        System.out.println(configProperties.getString("database.url"));
    }
}