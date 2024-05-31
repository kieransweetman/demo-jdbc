package fr.diginamic.census.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.census.entities.Department;

public class DepartmentDao extends AbstractDao<Department> {
    @Override
    public List<Department> extract() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Department insert(Department obj) {
        Department department = new Department();

        String sql = "INSERT INTO public.Department (code) VALUES (?) RETURNING *";
        try (PreparedStatement stmt = this.prepareStatement(sql)) {
            stmt.setString(1, obj.getCode());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getResultSet()) {
                department.setId(rs.getInt("id"));
                department.setCode(rs.getString("code"));
            }

        } catch (SQLException e) {
            this.rollBack();
            e.printStackTrace();
        } finally {
            this.commit();
        }

        return department;
    }

    @Override
    public int update(Department obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Boolean delete(Department obj) {
        // TODO Auto-generated method stub
        return null;
    }

}
