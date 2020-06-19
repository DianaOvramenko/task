package ui;

import base.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static core.helpers.enums.TestDataEnums.City;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Home Page")
public class HomePageTest extends BaseTest {

    @BeforeEach
    void beforeTest() {
        open(Configuration.baseUrl);
    }

    @DisplayName("Test location select")
    @Story("Change user location")
    @ParameterizedTest
    @EnumSource(City.class)
    void testLocation(City city) {
        getHomePage().changeLocation(city);
        assertEquals(city.toString(), getHomePage().getHeader().getChangeCityLink().getText(),
                "Verify user location was changed");
    }

    @AfterEach
    void afterTest() {
        WebDriverRunner.getWebDriver().quit();
    }
}
