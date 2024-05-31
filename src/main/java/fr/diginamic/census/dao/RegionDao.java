package fr.diginamic.census.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.census.entities.Region;

public class RegionDao extends AbstractDao<Region> {
    @Override
    public List<Region> extract() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Region insert(Region obj) {
        Region region = new Region();
        String sql = "INSERT INTO public.Region (name) values (?)";

        try (PreparedStatement stmt = this.prepareStatement(sql)) {
            stmt.setString(1, obj.getName());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getResultSet()) {
                region.setId(rs.getInt("id"));
                region.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.commit();
        }

        return region;

    }

    @Override
    public int update(Region obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Boolean delete(Region obj) {
        String sql = "DELETE from public.region where id = ?";

        // TODO Auto-generated method stub
        return null;
    }

}
