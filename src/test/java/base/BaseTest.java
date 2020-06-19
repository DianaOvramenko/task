package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.pageobjects.HomePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.page;
import static core.helpers.enums.CoreEnums.ApplicationProperty.HOST;
import static core.helpers.utils.PropertyUtils.getApplicationProperty;

public class BaseTest {

    @BeforeAll
    public static void beforeSuite() {
        Configuration.baseUrl = getApplicationProperty(HOST);
        Configuration.headless = false;
        Configuration.browser = "chrome";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.timeout = 30000;
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    protected HomePage getHomePage() {
        return page(HomePage.class);
    }
}
