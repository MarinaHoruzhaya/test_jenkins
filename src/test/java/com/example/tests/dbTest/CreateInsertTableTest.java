package com.example.tests.dbTest;

import org.example.db.DBConnection;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.db.DBConnection.getConnection;
import static org.testng.Assert.assertTrue;

public class CreateInsertTableTest {

    @Test
    public void createTable() {
     //   String createSQL = "CREATE TABLE pdp_table (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100));";
     //   String insertSQL = "INSERT INTO pdp_table (name) VALUES ('Marina')";

        String selectSQL = "SELECT name FROM pdp_table ";
     //  String dropSQL = "DROP TABLE IF EXISTS pdp_table;";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
          //  statement.executeUpdate(createSQL);
         //   statement.executeUpdate(insertSQL);
            ResultSet resultSet = statement.executeQuery(selectSQL);
            assertTrue(resultSet.next());
            System.out.println(resultSet.getString("name"));
        //    statement.executeUpdate(dropSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
