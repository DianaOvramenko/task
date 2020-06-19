package core.pageobjects.controls;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.helpers.Log;
import io.qameta.allure.Story;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class PopupBlock {

    @FindBy(id = "sm-popup")
    private SelenideElement popup;

    @FindBy(css = ".sm-popup__body h1 span")
    private SelenideElement popupHeaderText;

    @FindBy(css = ".ui-autocomplete-input")
    private SelenideElement searchInput;

    @FindBy(css = ".sm-popup__body .sm-button__red")
    private SelenideElement submitSearchButton;

    @FindBy(css = ".sm-popup__body div span")
    private ElementsCollection options;

    private SelectContainer getSelectContainer() {
        return page(SelectContainer.class);
    }

    public SelenideElement getPopup() {
        return popup;
    }

    public SelenideElement getPopupHeaderText() {
        return popupHeaderText;
    }

    public ElementsCollection getOptions() {
        return options.filter(visible);
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public SelenideElement getSubmitSearchButton() {
        return submitSearchButton;
    }

    public void selectOption(String option) {
        getPopup().shouldBe(visible);
        getOptions().shouldHave(sizeGreaterThan(0));
        getOptions().filter(text(option)).first().click();
        getPopup().shouldNotBe(visible);
        Log.info("Select option from popup: " + option);
    }

    @Story("Search for option: {0}, on popup")
    public void searchOption(String option, String optionAutoComplete) {
        getPopup().shouldBe(visible);
        getSearchInput().shouldBe(visible, enabled).setValue(option);
        Log.info("Search for option: " + option);
        getSelectContainer().selectOption(optionAutoComplete);
        getPopupHeaderText().shouldHave(text(option));
        getSubmitSearchButton().shouldBe(visible, enabled).click();
        getPopup().shouldNotBe(visible);
        Log.info("Submit popup");
    }
}
