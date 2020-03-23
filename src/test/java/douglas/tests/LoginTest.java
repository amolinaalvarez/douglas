package douglas.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import douglas.pages.PublicPage;
import douglas.pages.LoginPage;
import douglas.pages.PrivatePage;
import douglas.utils.TestBase;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    @DataProvider
    public static Object[][] validCredentials() {
        // TODO: Move this information to a config file in order to avoid sharing it
        return new Object[][] { { "alvaromolinaalvarez@gmail.com", "alvaromolina10" } };
    }

    @DataProvider
    public static Object[][] invalidCredentials() {
        // TODO: Move this information to a config file in order to avoid sharing it
        return new Object[][] { { "invalid.email@example.com", "invalidpassword" } };
    }
	
    @BeforeMethod(alwaysRun = true)
        public void setUp() {
        super.setUp();
        PublicPage publicPage = new PublicPage(driver);
        publicPage.acceptCookies();
        publicPage.goToLoginPage();
    }

    @Test(description = "As an user with correct credentials I would like to be able to login to the webshop", groups = {
			"regression" }, dataProvider = "validCredentials")
    public void loginOKTest(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        PrivatePage privatePage = new PrivatePage(driver);
        assertTrue(privatePage.isWelcomentInformationShown());
        assertTrue(privatePage.isNavigationShown());
    }

    @Test(description = "As a user I would like to receive an error message, if I enter wrong credentials.", groups = {
            "regression" }, dataProvider = "invalidCredentials")
    public void loginKOTest(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        assertTrue(loginPage.isErrorShown());
    }

    @Test(description = "As a user, I would like to be able to reset my password if I forget my credentials.", groups = {
            "regression" })
    public void resetPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToResetPasswordPage();
        assertTrue(loginPage.isResetPasswordModalShown());
    }

}
