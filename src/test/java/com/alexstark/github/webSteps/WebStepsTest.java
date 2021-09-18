package com.alexstark.github.webSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsTest {

    @Step("Открыть главную страницу github.com")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Найти репозиторий {repository}")
    public void searchForRepository(String repository) {
        $("[placeholder='Search GitHub']").val(repository).submit();
    }

    @Step("Перейти в репозиторий")
    public void goToRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Перейти в раздел Issues")
    public void openIssuesTab() {
        $(byPartialLinkText("Issues")).click();
    }

    @Step("Проверить, что существует Issue с номером {issueNumber}")
    public void shouldSeeIssueWithNumber(String issueNumber) {
        $(withText(issueNumber)).shouldBe(Condition.visible);
    }
}
