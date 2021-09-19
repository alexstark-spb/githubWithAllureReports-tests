package com.alexstark.github.webSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsTest {

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] annotatedAttachment() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Step("Открыть главную страницу github.com")
    public void openMainPage() {
        open(baseUrl);
        annotatedAttachment();
    }

    @Step("Найти репозиторий {repository}")
    public void searchForRepository(String repository) {
        $("[placeholder='Search GitHub']").val(repository).submit();
        annotatedAttachment();
    }

    @Step("Перейти в репозиторий")
    public void goToRepository(String repository) {
        $(byLinkText(repository)).click();
        annotatedAttachment();
    }

    @Step("Перейти в раздел Issues")
    public void openIssuesTab() {
        $(byPartialLinkText("Issues")).click();
        annotatedAttachment();
    }

    @Step("Проверить, что существует Issue с номером {issueNumber}")
    public void shouldSeeIssueWithNumber(String issueNumber) {
        $(withText(issueNumber)).shouldBe(Condition.visible);
        annotatedAttachment();
    }
}
