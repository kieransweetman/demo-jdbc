package fr.diginamic.census;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.census.entities.City;
import fr.diginamic.props.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        Connection conn = new DatabaseConnection().getConnection();

        try {
            Scanner scanner = new Scanner(new File("src/main/java/fr/diginamic/census/census.csv"));
            scanner.useDelimiter(";");
            // head
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                String departmentId = line[]
                City city = new City(0, line[5], line[9], 0, 0)
                // Use the line to populate your database
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void syso(String s) {
        System.out.println(s);
    }

}
