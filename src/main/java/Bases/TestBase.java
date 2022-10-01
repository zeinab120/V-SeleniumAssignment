package Bases;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;

    public static <String, Object> ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("--window-size=1024x768");
        return options;
    }

    @BeforeSuite
    public void OpenDriver(@Optional("chrome") String browserName)  {
        if (browserName.equalsIgnoreCase("chrome")) {
          WebDriverManager.chromedriver().clearCache();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
            driver.manage().window().maximize();
            driver.navigate().to("http://automationpractice.com/index.php");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }
    @AfterSuite
    public void CloseDriver(){
        driver.quit();
    }
}