package douglas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
    }

	private By emailField = By.name("email");
	private By passwordField = By.name("password");
	private By loginButton = By.cssSelector("[data-ui-name='submitLoginForm']");
	private By errorsDiv = By.cssSelector("[data-ui-name='globalError']");
	// TODO: Improve selector, avoid getting it from text
	private By resetPasswordLink = By.linkText("Passwort vergessen?");
	private By resetPasswordModal = By.cssSelector("[data-wt-component='Forgot Password Modal']");
	

    public void login(String username, String password) {
    	driver.findElement(emailField).sendKeys(username);
    	driver.findElement(passwordField).sendKeys(password);
    	driver.findElement(loginButton).click();
    }
    
    public void goToResetPasswordPage() {
    	driver.findElement(resetPasswordLink).click();
    }
    
    public boolean areErrorsShown() {
    	return driver.findElement(errorsDiv).isDisplayed();
    }
    
    public boolean isResetPasswordModalShown() {
    	return driver.findElement(resetPasswordModal).isDisplayed();
    }

}
