package com.alexstark.github.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {

    @BeforeAll
    static void beforeAll() {
        startMaximized = true;
        baseUrl = "https://github.com";
    }

    @Test
    public void testRepositoryIssue() {
        open(baseUrl);
        $("[placeholder='Search GitHub']").val("selenide/selenide").submit();
        $(byLinkText("selenide/selenide")).click();
        $(byPartialLinkText("Issues")).click();
        $(withText("#1561")).shouldBe(Condition.visible);
    }
}
