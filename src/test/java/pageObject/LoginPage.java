package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver Idriver;
	 public LoginPage(WebDriver rDriver)
	 {
		 Idriver = rDriver;
		 PageFactory.initElements(rDriver, this);
	 }
	 @FindBy(id = "user-name")
	 WebElement username;
	 
	 @FindBy(id = "password")
	 WebElement password;

	 @FindBy(id = "login-button")
	 WebElement login_buttton;
	 
	 @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	 WebElement side_menu;
	 
	 @FindBy(id = "logout_sidebar_link")
	 WebElement logout_buttton;
	 
     @FindBy(xpath="//div[@class='error-message-container error']/h3[@data-test='error']")
	 WebElement errorMessage;
	 
	 public void enterUserName(String user)
	 {
		 username.sendKeys(user);
	 }
	 public void enterPassword(String pwd)
	 {
		 password.sendKeys(pwd);
	 }
	 public void loginButton()
	 {
		 login_buttton.click();
	 }
	 public void sideMenu()
	 {
		 side_menu.click();
	 }
	 public void logout_Button()
	 {
		 logout_buttton.click();
	 }
	 public String errorMessage()
	 {
		 return errorMessage.getText().trim();
	 }


}

