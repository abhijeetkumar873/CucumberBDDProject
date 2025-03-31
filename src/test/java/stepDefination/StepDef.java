package stepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.Utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddProduct;
import pageObject.CartList;
import pageObject.LoginPage;

//* Child class of BaseClass

public class StepDef extends BaseClass
{
	@Before("@Sanity")
	public void setup1()
	{
		
		readConfig = new ReadConfig();
		
		log = LogManager.getLogger(StepDef.class);
		
		System.out.println("setup 1: Sanity Test Executed.");
		
		String browser = readConfig.getBrowser();
		System.out.println("Browser Name:"+browser);
		switch (browser.toLowerCase())
		
		{
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\abhijeakumar2\\OneDrive - Sopra Steria\\Automation\\eclipse-java-2024-09-R-win32-x86_64"
					+ "\\eclipse-workspace\\Cucumber_Freamework\\exefiles\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.manage().window().maximize();
			 
			 log.info("setup 1: Sanity Test Executed.");
			 break;
			 
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
	}
	@Before("@Regression")
	public void setup2()
	{
		log = LogManager.getLogger("StepDef");
		System.out.println("setup 2: Regression Test Executed.");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\abhijeakumar2\\OneDrive - Sopra Steria\\Automation\\eclipse-java-2024-09-R-win32-x86_64"
				+ "\\eclipse-workspace\\Cucumber_Freamework\\exefiles\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 log.info("setup 2: Regression Test Executed.");	 
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() 
	{
		
		loginPage = new LoginPage(driver);
		addproduct = new AddProduct(driver);
		cartList = new CartList(driver);
		log.info("launched browser successfully.");
	}
	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
		log.info("URL Open");
	}
	@When("user enter username {string} and password {string}")
	public void user_enter_username_and_password(String user, String pass) 
	{
		loginPage.enterUserName(user);
		loginPage.enterPassword(pass); 
		log.info("Entered Username and password");
	}
	@When("click on login button.")
	public void click_on_login_button() 
	{
		loginPage.loginButton(); 
		log.info("loggin button clicked.");
	}
	@Then("Page Title Should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.equals(actualTitle)) {
		    Assert.assertTrue(true, "Title matches.");
		} else {
		    Assert.fail("Title does not match. Expected: " + expectedTitle + ", but got: " + actualTitle);
		}
		log.info("Title not Matched");
	}
	@When("user click on menu button")
	public void user_click_on_menu_button() 
	{
		loginPage.sideMenu();
		
	}
	@When("user click on logout link")
	public void user_click_on_logout_link()
	{
		loginPage.logout_Button();
		
	}
	@Then("close browser.")
	public void close_browser() 
	{
		driver.close();  
	}
	
	@Then("Error message Should be {string}")
	public void error_message_should_be(String actualTitle) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(loginPage.errorMessage());
	   String expectedTitle = loginPage.errorMessage();
	   
	   if (expectedTitle.equals(actualTitle)) {
		    Assert.assertTrue(true, "Title matches.");
		} else {
		    Assert.fail("Title does not match. Expected: " + expectedTitle + ", but got: " + actualTitle);
		}
	   log.warn("Error Message not validated.");
	}
	
	/// Add product to cart ////////////
	
	
	@Then("user can view the {string} on the homepage")
	public void user_can_view_the_on_the_homepage(String actTitle) 
	{
		String expTitle = addproduct.getPageTitle();
		if (expTitle.equals(actTitle)) {
		    Assert.assertTrue(true, "Title matches.");
		} else {
		    Assert.fail("Title does not match. Expected: " + expTitle + ", but got: " + actTitle);
		} 
		log.info("Title Matched.");
	}
	
	@When("user click on filter button")
	public void user_click_on_filter_button() 
	{
		addproduct.filterbutton(); 
		log.info("Clicked on filter buttons");
	}
	

	@When("select the {string}")
	public void select_the_price_low_to_high(String filterOption) 
	{
		addproduct.selectFilterOption(filterOption); 
	}

	@When("user clicks Add to Cart for {string}")
	public void click_on_add_to_cart_button(String product) 
	{
		addproduct.clickAddToCart(product);
	}

	@Then("button name should change with {string}")
	public void button_name_should_change_with(String actButtonName)
	{
		String expButtonName = addproduct.getButtonName();
		if (expButtonName.equals(actButtonName)) {
		    Assert.assertTrue(true, "Title matches.");
		} else {
		    Assert.fail("Title does not match. Expected: " + expButtonName + ", but got: " + actButtonName);
		}   
		log.info(expButtonName+ ":Replaced  Button");
	}
	
	//***************** Validate Cart List *******************//
	
	@Then("click on cart icon")
	public void click_on_cart_icon() {
		
		cartList.clickOnCart();
	}

	@Then("user can view Product added successfully in cart")
	public void user_can_view_product_added_successfully_in_cart() {
		//cartList.getProductName();
	}

	@Then("verify only selected product should be added in the cart.")
	public void verify_only_selected_product_should_be_added_in_the_cart() {
	    
	}
	
	
	@After
	public void tearDown(Scenario sc) throws IOException
	{
		System.out.println("Tear Down method executed");
		if(sc.isFailed()== true)
		{
			String path ="C:\\Users\\abhijeakumar2\\OneDrive - Sopra Steria\\Automation\\eclipse-java-2024-09-R-win32-x86_64\\eclipse-workspace\\Cucumber_Freamework\\target\\screenshots\\test1.png";
			TakesScreenshot scrshot = ((TakesScreenshot)driver);
			File srcfile = scrshot.getScreenshotAs(OutputType.FILE);
			File DestFile= new File(path);
			FileUtils.copyFile(srcfile, DestFile);
			
		}
		driver.quit();
	}
	// Runs before each step
//    @BeforeStep
//    public void beforeStep() {
//        System.out.println("Before each step executed...");
//    }
//
//    // Runs after each step (useful for taking screenshots)
    @AfterStep
    public void addScreenshot(Scenario scenario)
    {
    	if(scenario.isFailed())
    	{
    		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png", scenario.getName());
    	}
    	
    	
        
    }
}
