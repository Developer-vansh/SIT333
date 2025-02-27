package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Vansh");
		
		/*
		 * Find following input fields and populate with values
		 */
		
		//lastNAme
		 WebElement lastName = driver.findElement(By.id("lastname"));
         lastName.sendKeys("Gaba");
         
         //phone
         WebElement phone = driver.findElement(By.id("phoneNumber"));
         phone.sendKeys("4440000555");
         
         //mail
         WebElement email = driver.findElement(By.id("email"));
         email.sendKeys("s224340121@dekain.edu.au");
         
         //password
         WebElement password = driver.findElement(By.id("password"));
         password.sendKeys("12345");  // Weak password for error message
         
         //confirm-password
         WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
         confirmPassword.sendKeys("12345");  
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
         WebElement createAccountButton = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
         createAccountButton.click();
         System.out.println("Clicked 'Create account' button.");
		
		/*
		 * Take screenshot using selenium API.
		 */
         File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         try {
             FileUtils.copyFile(screenshot, new File("officeworks_screenshot.png"));
             System.out.println(" Screenshot saved as officeworks_screenshot.png");
         } catch (IOException e) {
             System.out.println("Failed to save screenshot: " + e.getMessage());
         }

		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	public static void mongodb_registeration_page(String url)
	{
		// Locatng the chrome driver in the drive
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// using the chromium driver to open the chrome browser
		System.out.println("Opening the Chrome browser");
		WebDriver driver= new ChromeDriver();
		System.out.println("Driver Info:- "+ driver);
		
		sleep(2);
		
		// Now load the passed url in webbrowser 
		driver.get(url);
		
		// Now get all the fields using driver and pass them values
		
		// email address
		WebElement email=  driver.findElement(By.id("emailAddress"));
		System.out.println("Founded Email Element "+ email);
		email.sendKeys("s224340121@dekain.edu.au");
		
		// firstName
		WebElement fName=  driver.findElement(By.id("firstName"));
		System.out.println("Founded firstName Element "+ fName);
		fName.sendKeys("Vansh");
		
		//lastName
		WebElement lName= driver.findElement(By.id("lastName"));
		lName.sendKeys("Gaba");
		
		// password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("12345");  // Weak password for error message
		
		//checkbox
        WebElement label = driver.findElement(By.xpath("//label[@for='checkbox-1']"));
        label.click();
        
        // SignUp button
         WebElement signUpButton = driver.findElement(By.xpath("//button[@data-testid='submitButton']"));
         signUpButton.click();
         System.out.println("Clicked 'SignUp' button.");
		
		/*
		 * Take screenshot using selenium API.
		 */
         File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         try {
             FileUtils.copyFile(screenshot, new File("mongodb_screenshot.png"));
             System.out.println(" Screenshot saved as mongodb_screenshot.png");
         } catch (IOException e) {
             System.out.println("Failed to save screenshot: " + e.getMessage());
         }

			
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
		
		
	}
	
	
}
