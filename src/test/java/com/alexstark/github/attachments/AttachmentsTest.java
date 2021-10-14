package com.alexstark.github.attachments;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @Test
    public void testAttachment(){
        open("https://github.com");
        step("Сделали скриншот с помощью Аннотации", ()-> {
            annotatedAttachment();
            takePageSource();
        });

        step("Сделали скриншот с помощью метода", ()-> {
            String source = WebDriverRunner.getWebDriver().getPageSource();
            Allure.attachment("Исходный код страницы", source);
        });

    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] annotatedAttachment(){
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value = "Странице", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
}
