package com.alexstark.lambdaSteps;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LambdaStepsTest {

    private final String REPOSITORY = "selenide/selenide";
    private final String ISSUE_NUMBER = "#1561";

    @BeforeAll
    static void beforeAll() {
        startMaximized = true;
        baseUrl = "https://github.com";
    }

    @Test
    public void testRepositoryIssue() {
        step("Открыть главную страницу github.com", () -> {
            open(baseUrl);
        });

        step("Найти репозиторий " + REPOSITORY, ()->{
            $("[placeholder='Search GitHub']").val(REPOSITORY).submit();
        });

        step("Перейти в репозиторий", ()->{
            $(byLinkText(REPOSITORY)).click();
        });

        step("Перейти в раздел Issues", ()->{
            $(byPartialLinkText("Issues")).click();
        });

        step("Проверить, что существует Issue с номером " + ISSUE_NUMBER, ()->{
            $(withText(ISSUE_NUMBER)).shouldBe(Condition.visible);
        });
    }
}
