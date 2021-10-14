package com.alexstark.github.webSteps;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;

public class AnnotatedStepTest {

    private final String REPOSITORY = "selenide/selenide";
    private final String ISSUE_NUMBER = "#1561";

    private WebStepsTest steps = new WebStepsTest();

    @BeforeAll
    static void beforeAll() {
        startMaximized = true;
        baseUrl = "https://github.com";
    }

    @Test
    @Feature("Issues")
    @Story("Поиск по Issue")
    @Owner("Alex Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "GitHub", url = "https://github.com")
    @Description("Здесь находится некий текст-описание для теста")
    @DisplayName("Проверка отображения Issue на странице")
    public void shouldSeeIssueInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
