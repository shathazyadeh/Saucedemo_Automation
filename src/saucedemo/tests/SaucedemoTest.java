package saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaucedemoTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		// Verify logo display
		
		boolean logoDisplayed=driver.findElement(By.cssSelector("div.login_logo")).isDisplayed();
		String logoText = driver.findElement(By.cssSelector("div.login_logo")).getText();

		System.out.println("Logo is displayed: " + logoDisplayed);
		System.out.println("Logo text is: " + logoText);
	   
		//Verify input fields & login button display
		
		boolean usernameDisplayed = driver.findElement(By.id("user-name")).isDisplayed();
        boolean passwordDisplayed = driver.findElement(By.id("password")).isDisplayed();
        boolean loginButtonDisplayed = driver.findElement(By.id("login-button")).isDisplayed();
        
        System.out.println("Username field is displayed: " + usernameDisplayed);
        System.out.println("Password field is displayed: " + passwordDisplayed);
        System.out.println("Login button is displayed: " + loginButtonDisplayed);
        
     // Negative Test Case for locked_out_user
        
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    
        // Verify error message
        
        boolean isErrorDisplayed = driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
        String errorText = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        System.out.println("Locked user error displayed: " + isErrorDisplayed);
        System.out.println("Error message text: " + errorText);
        
     //clear user name field
        driver.findElement(By.id("user-name")).clear();
        
		//Enter standard user login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");     
        driver.findElement(By.id("login-button")).click();

        // Verify successful login and redirect to inventory page
        
        String currentUrl = driver.getCurrentUrl();
        boolean loginSuccess = currentUrl.contains("inventory.html");
        System.out.println("Login successful and redirected to inventory: " + loginSuccess);
   
        // close browser
        driver.quit();
        
        
        
	
	
	
	
	
	
	}
}