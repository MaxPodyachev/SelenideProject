package ru.yandex.market;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.allure.selenide.CustomAllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide());
    }

    @BeforeEach
    public void option() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
