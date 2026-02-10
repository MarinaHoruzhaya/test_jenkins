package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DocumentationPage {
    SelenideElement documentationTitle = $("h1");
    SelenideElement gitHubLink = $("a[href*='github.com/selenide/selenide']");
    SelenideElement openUrlMethod = $x("//a[text()='open(URL)']");
    SelenideElement methodDetailsTitle = $x("//section[@class='method-details']/h2");

     @Step("Открыть ссылку")
    public void clickOpenURLMethod() {
        openUrlMethod.click();
    }

    @Step("Получить текст")
    public String getTextOfMethodDetails() {
        return methodDetailsTitle.getText();
    }
}
