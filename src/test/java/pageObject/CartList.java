package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartList 
{
public WebDriver Idriver;
	
	public CartList(WebDriver rdriver)
	{
		Idriver = rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartButton;
	
	public void clickOnCart()
	{
		cartButton.click();
		
	}
//	public void getProductName()
//	{
//		for (WebElement product : cartProducts) 
//		{
//            System.out.println(product.getText());
//        }
//	}

}
