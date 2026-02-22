package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    @BeforeAll
    public static void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:4444/wd/hub";;
        // Для Selenium Grid
      //  Configuration.remote = "http://localhost:4445/wd/hub";

        ChromeOptions options = new ChromeOptions();
        Configuration.headless = true;

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        Configuration.browserCapabilities = options;
    }


    @BeforeEach
    public void setUp() {
        open("https://ru.selenide.org/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

