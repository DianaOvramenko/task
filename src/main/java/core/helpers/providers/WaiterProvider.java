package core.helpers.providers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WaiterProvider {

    public static void waitForPageLoaded() {
        waitForDocumentReady();
        waitForAjax();
    }

    public static void waitForDocumentReady() {
        WebDriver driver_ = getWebDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver_, Configuration.timeout);
        wait.until(driver -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public static void waitForAjax() {
        WebDriver driver_ = getWebDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver_, Configuration.timeout);
        wait.until(driver -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return jQuery.active"))
                .equals("0"));
    }
}
