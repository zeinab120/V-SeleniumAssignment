package Pages;
import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {

 private By hover_women =By.xpath("//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category' and @title='Women']");
 private By hover_Blouses= By.xpath("//li//a[@title='Blouses']");
 private By selectedProduct = By.xpath("//img[@title='Blouse']");
 private By txtBlouseResult = By.xpath("//span[@class='cat-name']");
 private By btn_addCart = By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']");
 private By addProductBtn1 = By.xpath("//a[@class='btn btn-default button button-medium']");
 private By txtSummaryMsg = By.xpath("//h1[@id='cart_title']");
 private By checkOutBtn2 = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
 private By txtAddressMsg = By.xpath(" //h1[@class='page-heading']");
 private By checkOutBtn3 = By.xpath("//button[@class='button btn btn-default button-medium']");
 private By txtShippingMsg = By.xpath("//div[@class='delivery_options_address']//p[@class='carrier_title']");
 private By checkOutBtn4 = By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']");
 private By txt_TermsConditions = By.xpath("//div[@id='uniform-cgv']");
 private By txtPaymentMsg = By.xpath("//div[@id='center_column']//h1[@class='page-heading']");
 private By selectedBankWire = By.xpath("//p[@class='payment_module']//a");
 private By confirmOrderBtn = By.xpath("//button[@class='button btn btn-default button-medium']");
 private By txtOrderConfirmationMsg = By.xpath("//p//strong[@class='dark']");
 private By backOrderBtn = By.xpath("//a[@title='Back to orders']//i");
 private By orderHistoryMessage = By.xpath("//h1[@class='page-heading bottom-indent']");
 private By resultMessage = By.xpath("//tbody//tr[@class='first_item ']");

 public ProductPage(WebDriver driver)
 {

  super(driver);
 }

 public void addToCart() {
  hoverOnElement(hover_women);
  clickButton(hover_Blouses);
 }
 public void selectProduct() {

  hoverOnElement(selectedProduct);

 }
 public void proceedCheckoutProcces() {

  scrollTo(btn_addCart);
  clickButton(btn_addCart);
  clickButton(addProductBtn1);
 }
 public void proceedFirstCheckOutProcces() {
  scrollTo(checkOutBtn2);
  clickButton(checkOutBtn2);
 }
 public void proceedSecondCheckOutProcces() {
  scrollTo(checkOutBtn3);
  clickButton(checkOutBtn3);
  clickButton(txt_TermsConditions);
 }
 public void proceedSThirdCheckOutProcces() {
  clickButton(checkOutBtn4);
 }
 public void payOrder(){
  scrollTo(selectedBankWire);
  clickButton(selectedBankWire);
  clickButton(confirmOrderBtn);

 }
 public void backToOrder() {
  scrollTo(backOrderBtn);
  clickButton(backOrderBtn);
 }

 public boolean isBlouseDisplay() {
  return isDisplay(txtBlouseResult);
 }

 public String getBlouseText() {
  return getText(txtBlouseResult);
 }
 public String getSummaryMsg() {
  return getText(txtSummaryMsg);
 }

 public boolean isSummaryMsgDisplay() {
  return isDisplay(txtSummaryMsg);
 }
 public String getAddressMsg() {
  return getText(txtAddressMsg);
 }

 public boolean isAddressMsgDisplay() {
  return isDisplay(txtAddressMsg);
 }

 public String getShippingMsg() {
  return getText(txtShippingMsg);
 }

 public boolean isShippingMsgDisplay() {
  return isDisplay(txtShippingMsg);
 }
 public String getPaymentMsg() {
  return getText(txtPaymentMsg);
 }

 public boolean isPaymentMsgDisplay() {
  return isDisplay(txtPaymentMsg);
 }
 public String getOrderConfirmationMsg() {
  return getText(txtOrderConfirmationMsg);
 }

 public boolean isOrderConfirmationMsgDisplay() {
  return isDisplay(txtOrderConfirmationMsg);
 }
 public boolean isOrderHistoryMsgDisplay() {
  return isDisplay(resultMessage);
 }
 public String getOrderHistoryMsg() {
  return getText(orderHistoryMessage);
 }

 public boolean getResultText(String value) {
  return getText(resultMessage).contains(value);
 }


}
