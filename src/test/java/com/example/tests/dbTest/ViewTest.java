package com.example.tests.dbTest;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.db.DBConnection.getConnection;
import static org.testng.Assert.assertTrue;

public class ViewTest {
    @Test
    public void createTable() {
        String createViewSQL = "CREATE VIEW test_for_pdp AS SELECT actor_id, first_name FROM actor;";
        String selectSQL = "SELECT * FROM test_for_pdp;";
        String dropSQL = "DROP VIEW test_for_pdp;";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(createViewSQL);
            ResultSet resultSet = statement.executeQuery(selectSQL);
            assertTrue(resultSet.next());
            statement.executeUpdate(dropSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
