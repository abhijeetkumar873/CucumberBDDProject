package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProduct 
{
	public WebDriver Idriver;
	
	public AddProduct(WebDriver rdriver)
	{
		Idriver = rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath ="//span[@class='title']")
	WebElement pageTitle;
	
	@FindBy(className="product_sort_container")
	WebElement fliterbutton;
	
	 // Product name (this will be used dynamically in Step Definition)
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement productName;

    // Generic Add to Cart button (XPath will be constructed in step definition)
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCartButton;
	
	@FindBy(xpath ="//button[contains(text(),'Remove')]")
	WebElement changeButton;
	
	
	
	public String getPageTitle() 
	{
        return pageTitle.getText();
    }
	
	public void filterbutton()
	{
		fliterbutton.click();
	}
	 public void selectFilterOption(String filterOption) 
	 {
	        Select select = new Select(fliterbutton);
	        select.selectByVisibleText(filterOption);
	  }
	public void clickAddToCart(String product)
	{
		 String dynamicXpath = "//div[text()='" + product + "']/ancestor::div[@class='inventory_item']//button";
		 Idriver.findElement(By.xpath(dynamicXpath)).click();
	}
	public String getButtonName()
	{
		return changeButton.getText();
	}
}
