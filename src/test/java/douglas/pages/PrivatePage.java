package douglas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivatePage {

	WebDriver driver;

	public PrivatePage(WebDriver driver) {
		this.driver = driver;
	}

	private By navigation = By.cssSelector("[data-wt-component='Navigation']");
	private By welcomeDiv = By.cssSelector("[data-wt-component='welcome']");

	public boolean isNavigationShown() {
		return driver.findElement(navigation).isDisplayed();
	}
	
	public boolean isWelcomentInformationShown() {
		return driver.findElement(welcomeDiv).isDisplayed();
	}

}
