package fr.diginamic.census;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;

import fr.diginamic.census.dao.CityDao;
import fr.diginamic.census.dao.DepartmentDao;
import fr.diginamic.census.dao.RegionDao;
import fr.diginamic.census.entities.City;
import fr.diginamic.census.entities.Department;
import fr.diginamic.census.entities.Region;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("src/main/java/fr/diginamic/census/census.csv"));
            scanner.useDelimiter(";");
            // head
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            DepartmentDao departmentDao = new DepartmentDao();
            RegionDao regionDao = new RegionDao();
            CityDao cityDao = new CityDao();

            long startTransactions = System.nanoTime();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                String departmenetCode = line[2];
                String regionName = line[1];
                String communeName = line[6];
                int population = Integer.parseInt(line[9].replace(" ", ""));

                // Department
                Department department = new Department();
                department.setCode(departmenetCode);
                Department addedDepartment = departmentDao.insert(department);
                ////////

                // Region
                Region region = new Region();
                region.setName(regionName);
                Region addedRegion = regionDao.insert(region);
                ////////

                // City
                City city = new City();
                city.setName(communeName);
                city.setPopulation(population);
                city.setDepartmentId(addedDepartment.getId());
                city.setRegionId(addedRegion.getId());
                cityDao.insert(city);
                ////////

            }
            long endTrans = System.nanoTime();
            syso("time to insert = :" + (endTrans - startTransactions));
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void syso(String s) {
        System.out.println(s);
    }

}
