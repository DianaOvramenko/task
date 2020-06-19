package ui;

import base.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static core.helpers.enums.TestDataEnums.City;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Feature("Home Page")
public class HomePageTest extends BaseTest {

    @DisplayName("Test location select")
    @Story("Change user location")
    @ParameterizedTest
    @EnumSource(City.class)
    void testLocation(City city) {
        getHomePage().changeLocation(city);
        assertEquals(city.toString(), getHomePage().getHeader().getChangeCityLink().getText(),
                "Verify user location was changed");
    }

    @DisplayName("Negative: Test location select")
    @Story("Change user location")
    @ParameterizedTest
    @ValueSource(strings = {"Харьков", "Invalid", "123!<>,.", "г Липецк", "Липецкая обл"})
    void testLocationNegative(String value) {
        assertFalse(getHomePage().checkLocationSearch(value),
                "Verify invalid option is not present in autocomplete options");
    }

    @AfterEach
    void afterTest() {
        WebDriverRunner.getWebDriver().quit();
    }
}
