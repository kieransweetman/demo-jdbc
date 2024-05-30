package fr.diginamic.props;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestInsert {

    public static void main(String[] args) throws SQLException {

        Connection db = new DatabaseConnection().getConnection();

        ArrayList<Producer> producers = new ArrayList<Producer>(); // Specify the type parameter for ArrayList

        db.createStatement()
                .executeUpdate("INSERT into public.producer ( name, item) values ('dfdfd', 'toes')");
        db.createStatement()
                .executeUpdate(
                        "INSERT into public.producer ( name, item) values ('oneTwo333Three', 'jeans')");

        ResultSet cursor = db.createStatement().executeQuery("select * from public.producer");

        while (cursor.next()) {
            int id = cursor.getInt("id");
            String name = cursor.getString("name");
            String item = cursor.getString("item");

            producers.add(new Producer(id, name, item));

        }

        for (Producer p : producers) {
            System.out.println(p.toString());
        }

        cursor.close();

    }

}
