package com.alexstark.github.lambdaSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

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

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] annotatedAttachment(){
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Test
    @DisplayName("Проверка отображения Issue на странице")
    public void testRepositoryIssue() {

        Allure.feature("Issues");
        Allure.story("Поиск по Issue");
        Allure.label("owner", "Alex Derevyanko");
        Allure.label("Severity", SeverityLevel.NORMAL.toString());
        Allure.link("GitHub","https://github.com");
        Allure.description("Здесь находится некий текст-описание для теста");

        step("Открыть главную страницу github.com", () -> {
            open(baseUrl);
            annotatedAttachment();
        });

        step("Найти репозиторий " + REPOSITORY, ()->{
            $("[placeholder='Search GitHub']").val(REPOSITORY).submit();
            annotatedAttachment();
        });

        step("Перейти в репозиторий", ()->{
            $(byLinkText(REPOSITORY)).click();
            annotatedAttachment();
        });

        step("Перейти в раздел Issues", ()->{
            $(byPartialLinkText("Issues")).click();
            annotatedAttachment();
        });

        step("Проверить, что существует Issue с номером " + ISSUE_NUMBER, ()->{
            $(withText(ISSUE_NUMBER)).shouldBe(Condition.visible);
            annotatedAttachment();
        });
    }
}
