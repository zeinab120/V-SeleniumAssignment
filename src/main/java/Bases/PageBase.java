package Bases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public WebDriver driver;
    public Actions action;
    public JavascriptExecutor js;
    public WebDriverWait wait;
    Select select;

    public PageBase(WebDriver driver){
        this.driver=driver;
            action = new Actions(driver);
            wait = new WebDriverWait(driver, 30);
            js = (JavascriptExecutor) driver;
        }

    protected void clickButton(By button)
    {
       driver.findElement(button).click();
    }

    protected void setTextElement(By element , String value){

        driver.findElement(element).sendKeys(value);
    }
 protected void clearTxt(By element){
        driver.findElement(element).clear();
 }
protected void selectByVisualTxt(By element, String value){
     select = new Select(driver.findElement(element));
    select.selectByVisibleText(value);
}
protected void hoverOnElement(By element){
        action.moveToElement(driver.findElement(element)).perform();
}

  protected void scrollTo(By element){
    js.executeScript("window.scrollBy(0,375)");
}

    public String getText(By element) {

        return driver.findElement(element).getText();
    }
    public boolean isDisplay(By element) {

        return driver.findElement(element).isDisplayed();

        }


}
