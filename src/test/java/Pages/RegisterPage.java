package Pages;
import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class RegisterPage extends PageBase {

    //  By registerEmailAddress = By.id("email_create");
    private   By registerEmail = By.xpath("//input[@name='email_create']");
    private By CreateAccountBtn = By.xpath(" //button[@id='SubmitCreate']//span");
    //Register Form
    private By txt_customerFirstname= By.id("customer_firstname");
    private By txt_customerLastname = By.id("customer_lastname");
    private By txt_Password = By.id("passwd");
    //Address section
    private By txt_Address = By.id("address1");
    private By txt_City = By.id("city");
    private By txt_State = By.id("id_state");
    private By txt_ZipCode = By.id("postcode");
    private By txt_MobilePhone= By.xpath("//p//input[@id='phone_mobile']");
    private By txt_AddressAlias= By.id("alias");
    private By btn_registration = By.xpath("//button[@id='submitAccount']//span");
    //Verify user loggedIn
    private By registeredMess = By.xpath("//p[@class='info-account']");
    private By btn_signOut =By.xpath("//a[@class='logout']");
    private By txt_signOutMsg =By.xpath("//h1[@class='page-heading']");

    //Random method
    String emailDomain = "@gmail.com";
    public int generateEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(999999);
        return randomInt;
    }
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void sentEmailToRegister(String email){
        clearTxt(registerEmail);
        setTextElement(registerEmail, email + generateEmail() + emailDomain);
        clickButton(CreateAccountBtn);
    }

    public void registerPage(String firstName, String lastName,String password , String address, String city, String state, String zipCode
            ,String mobilePhone,String addressAlias){
        setTextElement(txt_customerFirstname,firstName);
        setTextElement(txt_customerLastname,lastName);
        setTextElement(txt_Password,password);
        setTextElement(txt_Address,address);
        setTextElement(txt_City,city);
        selectByVisualTxt(txt_State,state);
        setTextElement(txt_ZipCode,zipCode);
        setTextElement(txt_MobilePhone,mobilePhone);
        clearTxt(txt_AddressAlias);
        setTextElement(txt_AddressAlias, addressAlias);
        clickButton(btn_registration);
    }
  public boolean verifyMessage(){
        return isDisplay(registeredMess);
  }
    public void navigateToLogOut(){
        clickButton(btn_signOut);
    }
    public String outsettingMsgText() {
        return getText(txt_signOutMsg);

    }

}
