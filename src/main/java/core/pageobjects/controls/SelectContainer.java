package core.pageobjects.controls;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.helpers.Log;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SelectContainer {

    @FindBy(css = ".ui-autocomplete")
    private SelenideElement selectContainer;

    @FindBy(css = ".ui-menu-item")
    private ElementsCollection options;

    public SelenideElement getSelectContainer() {
        return selectContainer;
    }

    public ElementsCollection getOptions() {
        return options;
    }

    public void selectOption(String option) {
        getSelectContainer().shouldBe(visible);
        getOptions().shouldHave(sizeGreaterThan(0)).filter(text(option)).first().click();
        getSelectContainer().shouldNotBe(visible);
        Log.info("Select option from autocomplete block: " + option);
    }
}
