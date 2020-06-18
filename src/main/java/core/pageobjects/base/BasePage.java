package core.pageobjects.base;

import core.helpers.Log;
import core.helpers.enums.TestDataEnums.City;
import core.pageobjects.controls.HeaderBlock;
import core.pageobjects.controls.PopupBlock;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {

    public HeaderBlock getHeader() {
        return page(HeaderBlock.class);
    }

    private PopupBlock getPopup() {
        return page(PopupBlock.class);
    }

    @Step("Change location")
    public void changeLocation(City city) {
        getHeader().getChangeCityLink().shouldBe(visible).click();
        getPopup().searchOption(city.toString(), city.getLocation());
        getHeader().getChangeCityLink().shouldHave(text(city.toString()));
        Log.info("Change user location: " + city.toString());
    }
}
