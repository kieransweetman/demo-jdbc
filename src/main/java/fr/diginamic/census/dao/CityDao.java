package fr.diginamic.census.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.census.entities.City;
import fr.diginamic.census.entities.Department;

public class CityDao extends AbstractDao<City> {
    @Override
    public List<City> extract() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public City insert(City obj) {
        City city = new City();

        String sql = "INSERT INTO public.City (name, population, departmentId, regionId) VALUES (?, ?, ?, ?) RETURNING *";
        try (PreparedStatement stmt = this.prepareStatement(sql)) {

            stmt.executeUpdate();
        } catch (SQLException e) {
            this.rollBack();
            e.printStackTrace();
        } finally {
            this.commit();
        }

        return city;

    }

    @Override
    public int update(City obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Boolean delete(City obj) {
        // TODO Auto-generated method stub
        return null;
    }

}
