package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.pageobjects.HomePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static core.helpers.enums.CoreEnums.ApplicationProperty.HOST;
import static core.helpers.utils.PropertyUtils.getApplicationProperty;

public class BaseTest {

    @BeforeAll
    public static void beforeSuite() {
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.timeout = 30000;
        Configuration.startMaximized = true;
        Configuration.baseUrl = getApplicationProperty(HOST);
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeEach
    void beforeTest() {
        open(Configuration.baseUrl);
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
    }


    protected HomePage getHomePage() {
        return page(HomePage.class);
    }
}
