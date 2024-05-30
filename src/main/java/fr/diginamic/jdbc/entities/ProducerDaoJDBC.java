package fr.diginamic.jdbc.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.props.DatabaseConnection;
import fr.diginamic.props.Producer;

public class ProducerDaoJDBC implements ProducerDao {

    private Connection conn;

    public ProducerDaoJDBC() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = new DatabaseConnection().getConnection();
            } else {
                System.out.println("database connection already establised");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producer> extract() {
        String sql = "Select * from public.producer";
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            ArrayList<Producer> producers = new ArrayList<Producer>();

            while (result.next()) {

                producers.add(
                        new Producer(
                                result.getInt("id"),
                                result.getString("name"),
                                result.getString("item")));

            }

            return producers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(Producer producer) {
        String sql = "Delete from public.producer where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producer.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Producer producer) {
        String sql = "INSERT INTO public.producer (name, item) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producer.getName());
            pstmt.setString(2, producer.getItem());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(String prevName, String newName) {
        return 0;
    }

}
