package com.LumaBooking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaJacketBooking {

	private static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Click Sign In Button
		
		WebElement SignInBtn = driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
		SignInBtn.click();
		
		// Sign In Page
		
		WebElement EmailField = driver.findElement(By.id("email"));
		EmailField.sendKeys("durgakalaiyarasi@gmail.com");
		WebElement PasswordField = driver.findElement(By.cssSelector("input[title='Password']"));
		PasswordField.sendKeys("1907@Durga");


		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		
		WebElement SignInBtn1 = driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]"));
		SignInBtn1.click();
		
		
		//Search Product
		
		WebElement Men = driver.findElement(By.xpath("//span[text()='Men']"));
		WebElement Tops = driver.findElement(By.xpath("//a[@id='ui-id-17']"));
		WebElement Jacket = driver.findElement(By.xpath("//a[@id='ui-id-19']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(Men).build().perform();

		actions.moveToElement(Tops).build().perform();
		
		actions.moveToElement(Jacket).click().perform();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		WebElement JacketSelection = driver.findElement(By.xpath("(//img[@alt='Montana Wind Jacket'])[2]"));
		JacketSelection.click();
		
		js.executeScript("window.scrollBy(0,2000)");
		
		WebElement SizeSelection = driver.findElement(By.xpath("//div[text()='M']"));
		SizeSelection.click();
		WebElement ColorSelection = driver.findElement(By.xpath("//div[@option-label='Red']"));
		ColorSelection.click();
		
		WebElement AddToCart = driver.findElement(By.id("product-addtocart-button"));
		AddToCart.click();
		
		js.executeScript("window.scrollBy(0,-2000)");
		
		Thread.sleep(5000);
		WebElement ShowCart = driver.findElement(By.xpath("(//span[@class='counter qty'])[1]"));
		ShowCart.click();
		
		WebElement CheckOutPage = driver.findElement(By.id("top-cart-btn-checkout"));
		CheckOutPage.click();
		
		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement Company = driver.findElement(By.name("company"));
		Company.sendKeys("Greens Technologies");
		
		js.executeScript("window.scrollBy(0,200)");
		WebElement StreetField = driver.findElement(By.xpath("//input[@name='street[0]']"));
		StreetField.sendKeys("New Washermenpet, Chennai");
		
		js.executeScript("window.scrollBy(0, 200)");
		WebElement CityField = driver.findElement(By.xpath("//input[@name='city']"));
		CityField.sendKeys("Chennai");
		
		
		WebElement StateField = driver.findElement(By.xpath("//select[@name='region_id']"));
		Select S = new Select(StateField);
		S.selectByValue("4");
		
		WebElement postcodeField = driver.findElement(By.xpath("(//input[@name='postcode'])[1]"));
		postcodeField.sendKeys("600081");
		
		WebElement CountryField = driver.findElement(By.xpath("//select[@name='country_id']"));
		Select country = new Select(CountryField);
		country.selectByValue("DZ");
		
		WebElement PhonenumberField = driver.findElement(By.xpath("//input[@name='telephone']"));
		PhonenumberField.sendKeys("1234567890");
		
		WebElement Shipping = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		Shipping.click();
		
		WebElement NextBtn = driver.findElement(By.xpath("/span[text()='Next']"));
		NextBtn.click();
		
		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement PlaceOrder = driver.findElement(By.cssSelector("button[title='Place Order']"));
		PlaceOrder.click();
		
		WebElement ThankYouMsg = driver.findElement(By.xpath("//p[text()='Your order number is: ']"));
		System.out.println(ThankYouMsg.getText());
	}
	
	

}
