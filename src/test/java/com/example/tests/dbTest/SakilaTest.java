package com.example.tests.dbTest;

import org.example.db.DBConnection;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.sql.Connection;

import static org.testng.AssertJUnit.assertNotNull;

public class SakilaTest {

    @Test
    public void connectTest() {
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection);
    }
}
