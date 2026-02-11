package com.example.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.example.DocumentationPage;
import org.example.MainPage;
import org.example.QuestionPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTest extends BaseTest {
    private DocumentationPage documentationPage = new DocumentationPage();
    private MainPage mainPage = new MainPage();
    private QuestionPage questionPage = new QuestionPage();

    @Test()
    @Description("Успешный тест 1")
    public void checkPageObjectInfo() {

        mainPage.clickQuestionButton();
        questionPage.clickPageObjectInfo();

        Assert.assertEquals("Page Objects - это просто!", questionPage.getTextOfPageObjectTitle());
    }

    @Test()
    @Description("Успешный тест 2")
    public void checkDocumentationLink() {

        mainPage.clickDocumentationButton();
        documentationPage.clickOpenURLMethod();

        Assert.assertEquals("Method Details", documentationPage.getTextOfMethodDetails());
    }

    @Test()
    @Description("Упавший тест 1")
    public void failingTest() {

        mainPage.getMainTitle().shouldHave(text("Wrong Text"));
    }

    @Test()
    @Description("Упавший тест 2")
    public void anotherFailingTest() {

        mainPage.getMainTitle().shouldHave(text("another Wrong Text"));
    }

    @Test()
    @Description("Пропущенный тест")
    public void skippedTest() {
        $("h1").shouldHave(text("Selenide"));
        $("a[href*='github.com/selenide/selenide']").shouldBe(visible);
    }

    @Test( testName = "Проверка открытия GitHub в новой вкладке")
    @Description("Клик по ссылке GitHub и проверка новой вкладки")
    public void checkGitHubLinkOpensNewTab() {
        String originalWindow = getWebDriver().getWindowHandle();

        mainPage.clickMaven();
        mainPage.clickGitHubLink();


        Selenide.Wait().until(driver -> driver.getWindowHandles().size() > 1);
        Set<String> windows = getWebDriver().getWindowHandles();
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                getWebDriver().switchTo().window(window);
                break;
            }
        }

        Assert.assertTrue(
                webdriver().driver().url().contains("github.com/selenide/selenide"),
                "URL должно содержать GitHub репозиторий Selenide"
        );

        getWebDriver().switchTo().window(originalWindow);
    }



}
