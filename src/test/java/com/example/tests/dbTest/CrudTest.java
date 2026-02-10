package com.example.tests.dbTest;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.db.DBConnection.getConnection;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CrudTest {

    @Test
    public void joinTest() {
        String selectSql = "SELECT a.actor_id, a.first_name, ai.film_info " +
                "FROM actor a " +
                "JOIN actor_info ai ON a.actor_id = ai.actor_id " +
                "WHERE a.first_name ='PENELOPE'";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSql)) {

            assertNotNull(resultSet.getString("film_info"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insertDeleteTest() {
        String insertSql = "INSERT INTO actor (first_name, last_name, last_update) VALUES ('Marina', 'Horuzhaya', NOW())";
        String selectSql = "SELECT first_name FROM actor WHERE first_name = 'Marina';";
        String deleteSql = "DELETE FROM actor where first_name = 'Marina';";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertSql);
            ResultSet resultSet = statement.executeQuery(selectSql);
            resultSet.next();
            assertEquals(resultSet.getString("first_name"), "Marina");
            int deletedCount = statement.executeUpdate(deleteSql);
            assertEquals(deletedCount, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void nestedTest() {
        String selectSql = "SELECT first_name FROM actor WHERE actor_id IN (SELECT actor_id FROM film_actor WHERE film_id = 132);";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            List<String> actualNames = new ArrayList<>();
            while(resultSet.next()) {
                actualNames.add(resultSet.getString("first_name"));
            }
            List<String> expectedNames = List.of("NICK","GENE");
            assertEquals(actualNames,expectedNames);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void unionTest() {
        String unionSql = "SELECT actor_id, first_name, last_name from actor where first_name = 'PENELOPE' " +
                "UNION " +
                "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = 'GUINESS'";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(unionSql);
            int count = 0;
            while(resultSet.next()) {
                count ++;
            }
            assertEquals(count,6);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
