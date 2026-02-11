package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.example.DocumentationPage;
import org.example.MainPage;
import org.example.QuestionPage;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    @BeforeSuite
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:4444/wd/hub";;
        // Для Selenium Grid
      //  Configuration.remote = "http://localhost:4445/wd/hub";

        ChromeOptions options = new ChromeOptions();
        Configuration.headless = true;

        // Опции Chrome
        Configuration.browserCapabilities.setCapability(
                "goog:chromeOptions",
                Map.of(
                        "args", List.of(
                                "--no-sandbox",           // важно для CI
                                "--disable-dev-shm-usage",
                                "--disable-gpu",
                                "--window-size=1920,1080"
                        )
                )
        );

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        Configuration.browserCapabilities = options;
    }


    @BeforeMethod
    public void setUp() {
        open("https://ru.selenide.org/");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

