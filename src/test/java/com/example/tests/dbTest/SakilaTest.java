package com.example.tests.dbTest;

import org.example.db.DBConnection;
import org.junit.jupiter.api.Test;


import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SakilaTest {

    @Test
    public void connectTest() {
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection);
    }
}
