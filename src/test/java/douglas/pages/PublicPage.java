package douglas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublicPage {
	
	WebDriver driver;
	
	public PublicPage(WebDriver driver) {
		this.driver = driver;
    }
    
	private By loginPageLink = By.cssSelector("a[href*='/mydouglas/index.html']");
    private By cookiesButton = By.cssSelector("[data-wt-component='cookie.ok']");

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public void goToLoginPage() {
    	driver.findElement(loginPageLink).click();
    }
    
    public void acceptCookies() {
    	driver.findElement(cookiesButton).click();
    }
}


