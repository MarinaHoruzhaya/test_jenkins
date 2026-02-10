package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class QuestionPage {
    SelenideElement pageObjectInfo = $x("//a[@href = '/documentation/page-objects.html']");
    SelenideElement pageObjectTitle = $("#page-objects---это-просто");

    @Step("Кликнуть на подробнее о PageObject")
    public void clickPageObjectInfo() {
        pageObjectInfo.click();
    }

    @Step("Получить текст страницы PageObject")
    public String getTextOfPageObjectTitle() {
        return pageObjectTitle.getText();
    }


}
