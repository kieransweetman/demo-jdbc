package fr.diginamic.census.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.diginamic.props.DatabaseConnection;

public abstract class AbstractDao<T> implements GeneralDao<T> {
    protected Connection conn;

    public AbstractDao() {
        try {
            this.conn = DatabaseConnection.getInstance().getConnection();
            this.conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void commit() {
        try {
            this.conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected PreparedStatement prepareStatement(String rawSQL) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(rawSQL);
        return stmt;
    }

    protected void rollBack() {
        try {
            this.conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
