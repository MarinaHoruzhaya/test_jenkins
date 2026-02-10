package com.example.tests;

import org.testng.annotations.Test;

public class ExceptionTest2 {

    @Test
    public void myTest() {
        String test = null;

        test.length();
    }
}
