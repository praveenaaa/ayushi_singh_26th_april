package test.definition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class Test_Steps {
	public static WebDriver driver;
	@Given("^lalitha has registered in to TestMeApp$")
	public void lalitha_has_registered_in_to_TestMeApp() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

     driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");

     driver.manage().window().maximize();
     driver.findElement(By.linkText("SignIn")).click();
	}

	@When("^lalitha enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void lalitha_enter_Username_as_and_Password_as(String username, String password) throws Throwable {
		 driver.findElement(By.name("userName")).sendKeys(username);

		    driver.findElement(By.name("password")).sendKeys(password);

		       driver.findElement(By.name("Login")).click();
	}

	@When("^user search for particular product and enter product name as \"([^\"]*)\"$")
	public void user_search_for_particular_product_and_enter_product_name_as(String productname) throws Throwable {
		 WebElement search = driver.findElement(By.id("myInput"));
		 Thread.sleep(5000);
		  Actions a = new Actions(driver);
		a.keyDown(search,Keys.SHIFT).sendKeys(productname).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	@When("^try to proceed the payment without adding any item in cart$")
	public void try_to_proceed_the_payment_without_adding_any_item_in_cart() throws Throwable {
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	    //driver.findElement(By.xpath("//*[@id=\"quantity_1\"]")).clear();
	    WebElement quantity = driver.findElement(By.id("quantity_1"));
	    //quantity.click();
	    //Actions a = new Actions(driver);
	    //a.keyDown(quantity,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).sendKeys("0").build().perform();
	    quantity.clear();
	    //quantity.sendKeys("0");
	    //driver.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a")).click();
	    driver.switchTo().alert().accept();
	    driver.close();
	   
	}

	@Then("^TestMeApp doesn't display the cart icon$")
	public void testmeapp_doesn_t_display_the_cart_icon() throws Throwable {
	    System.out.print("TestMeApp doesn't display the cart icon");
	  //  throw new PendingException();
	}

}
