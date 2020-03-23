package douglas.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElementVisible(By by) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
