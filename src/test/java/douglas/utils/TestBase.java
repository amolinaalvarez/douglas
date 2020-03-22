package douglas.utils;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends DriverFactory {
	
	// TODO: Move this URL to the configuration file
	private static final String URL = "https://www.douglas.de";

    protected WebDriver driver = null;
    private static final long IMPLICIT_TIME = 5;
    
    @BeforeClass
	public static void setUpClass() {
    	WebDriverManager.chromedriver().setup();
    	WebDriverManager.firefoxdriver().setup();
	}

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
