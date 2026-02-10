package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement mainTitle = $(By.xpath("//h3[text()='Что такое Selenide?']"));
    private SelenideElement documentationButton = $("a[href='/documentation.html']");
    private SelenideElement quickStartButton = $("a[href='/quick-start.html']");
    private SelenideElement questionsButton = $x("//a[@href='/faq.html']");
    private SelenideElement youtubeIframe = $("iframe[src*='youtube']");
    private SelenideElement videoTitle = $("h1.title");

    public void switchToYouTubeIframe() {
        switchTo().frame(youtubeIframe);
    }

    public String getVideoTitle() {
        return videoTitle.text();
    }

    public void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    @Step ("Клинкуть на кнопку документации")
    public void clickDocumentationButton() {
        documentationButton.click();
    }

    @Step ("Клинкуть на кнопку quick start")
    public void clickQuickStartButton() {
        quickStartButton.click();
    }

    @Step ("Клинкуть на кнопку вопросов")
    public void clickQuestionButton() {
        questionsButton.click();
    }


    @Step("Получить тект заголовка на главной странице")
    public SelenideElement getMainTitle() {
        return mainTitle;
    }

    public void clickGitHubLink() {
        $("a[href='https://github.com/selenide/selenide']").click();
    }

    public void clickMaven () {
        $("a[href='https://central.sonatype.com/search?q=selenide&namespace=com.codeborne']").click();

    }
}
