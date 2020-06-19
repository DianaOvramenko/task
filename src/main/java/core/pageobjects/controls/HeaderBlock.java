package core.pageobjects.controls;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HeaderBlock {

    @FindBy(css = ".sm-header-bar__city-trigger a")
    private SelenideElement changeCityLink;

    public SelenideElement getChangeCityLink() {
        return changeCityLink;
    }
}
