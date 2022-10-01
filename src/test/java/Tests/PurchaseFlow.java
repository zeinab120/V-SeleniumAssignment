package Tests;
import Bases.TestBase;
import Data.ExcelReader;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.RegisterPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class PurchaseFlow extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    ProductPage productPage;


    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(driver);
    }
      // get data from Excel Reader class //
    @DataProvider(name="userRegisterData")
    public Object[][] userRegisterData() throws IOException, InvalidFormatException {

        ExcelReader ER =new ExcelReader();
        return ER.read_sheet();
    }
    @Test (priority = 1,dataProvider = "userRegisterData")

    public void userCanRegister(String email, String firstName, String lastName,String password , String address, String city, String state, String zipCode
            ,String mobilePhone,String addressAlias )
    {
        homePage.pressOnSignIn();
        registerPage=new RegisterPage(driver);
        registerPage.sentEmailToRegister(email);
        registerPage.registerPage(firstName,lastName,password,address,city,state,zipCode,mobilePhone,addressAlias);
        Assert.assertTrue(registerPage.verifyMessage());
        System.out.println("User is logged in ");
    }

    @Test(priority = 2)
    public void addToCarts() {
        productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.selectProduct();
        Assert.assertTrue(productPage.isBlouseDisplay());
        System.out.println("Message :" + productPage.getBlouseText());
        productPage.proceedCheckoutProcces();
        Assert.assertTrue(productPage.isSummaryMsgDisplay());
        System.out.println("Message :" + productPage.getSummaryMsg());
        productPage.proceedFirstCheckOutProcces();
        Assert.assertTrue(productPage.isAddressMsgDisplay());
        System.out.println("Message :" + productPage.getAddressMsg());
        productPage.proceedSecondCheckOutProcces();
        Assert.assertTrue(productPage.isShippingMsgDisplay());
        System.out.println("Message :" + productPage.getShippingMsg());
        productPage.proceedSThirdCheckOutProcces();
        Assert.assertTrue(productPage.isPaymentMsgDisplay());
        System.out.println("Message :" + productPage.getPaymentMsg());
        productPage.payOrder();
        Assert.assertTrue(productPage.isOrderConfirmationMsgDisplay());
        System.out.println("Message :" + productPage.getOrderConfirmationMsg());
        productPage.backToOrder();
        Assert.assertTrue(productPage.isOrderHistoryMsgDisplay());
        System.out.println("Message :" + productPage.getOrderHistoryMsg());
        Assert.assertTrue(productPage.getResultText("Bank wire"));

    }
    @Test(priority = 3)
    public void signOut(){
     registerPage.navigateToLogOut();
        System.out.println("Message :" + registerPage.outsettingMsgText());
        System.out.println("User is logged out ");
    }


}
