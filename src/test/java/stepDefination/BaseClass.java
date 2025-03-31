package stepDefination;

import java.util.Properties;

import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;

import com.Utilities.ReadConfig;

import pageObject.AddProduct;
import pageObject.CartList;
import pageObject.LoginPage;

public class BaseClass 

{
	public WebDriver driver;
	public LoginPage loginPage;
	public AddProduct addproduct;
	public CartList cartList;
	public static Logger log;
	public ReadConfig readConfig;

}
