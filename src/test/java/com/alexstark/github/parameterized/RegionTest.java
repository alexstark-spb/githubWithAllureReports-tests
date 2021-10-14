package com.alexstark.github.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class RegionTest {

    @ParameterizedTest(name = "Проверка сайта в регионах")
    @CsvSource({
            "Москва, Московская область",
            "Санкт-Петербург, Ленинградская область",
            "Омск, Омская область"
    })
    public void testReions(String city, String state) {

        parameter("Город", city);
        parameter("Область", state);


        step("Открываем сайт в регионе " + state);
        step("Проверяем что город определился как " + city);

    }
}
