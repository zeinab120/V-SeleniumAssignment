package Pages;

import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends PageBase {
    // By signInBtnLocator =By.partialLinkText("Sign in");
    By signInBtnLocator = By.xpath("//a[@title='Log in to your customer account']");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void pressOnSignIn() {
        clickButton(signInBtnLocator);
    }
    }
