package com.alexstark.github.webSteps;

import org.junit.jupiter.api.BeforeAll;
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
    public void shouldSeeIssueInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
