package saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaucedemoTest {

	public static void main(String[] args) throws InterruptedException{
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
        Thread.sleep(2000);
        
      // verify User name placeholder and Button Text
        
        String userNameplaceholder=driver.findElement(By.id("user-name")).getAttribute("placeholder");
        boolean isUsernameplaceholderCorrect = userNameplaceholder.equals("Username");
        System.out.println("username placeholder is correct: "+ isUsernameplaceholderCorrect);
        
       // verify Password placeholder
        String passwordPlaceholder=driver.findElement(By.id("password")).getAttribute("placeholder");
        boolean isPasswordPlaceholderCorrect = passwordPlaceholder.equals("Password");
        System.out.println("Password placeholder is correct: "+ isPasswordPlaceholderCorrect);
        
       // verify Login Button Text
        String loginText=driver.findElement(By.id("login-button")).getAttribute("value");
        boolean isLoginText = loginText.equals("Login");
        System.out.println("Login Text is correct: "+ isLoginText);
        
       
        // Negative Test Case for locked_out_user
        
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        // Verify error message
        
        boolean isErrorDisplayed = driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
        String errorText = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        System.out.println("Locked user error displayed: " + isErrorDisplayed);
        System.out.println("Error message text: " + errorText);
        Thread.sleep(2000);
     //clear user name field
        driver.findElement(By.id("user-name")).clear();
        Thread.sleep(2000);
		//Enter standard user login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");     
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        // Verify successful login and redirect to inventory page
        
        String currentUrl = driver.getCurrentUrl();
        boolean loginSuccess = currentUrl.contains("inventory.html");
        System.out.println("Login successful and redirected to inventory: " + loginSuccess);
        Thread.sleep(2000);
    
        
        
        /*Verify successful login and redirect to
         *  inventory page by checking the visibility 
         *  of the Logout link  
        */  
           
           boolean isMenuIconDisplayed = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
           System.out.println("Menu icon is displayed : " + isMenuIconDisplayed );
           
           driver.findElement(By.id("react-burger-menu-btn")).click();
           Thread.sleep(000);
           
           boolean isLogoutDisplayed = driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
           System.out.println("Logout Link is displayed : " + isLogoutDisplayed );
           Thread.sleep(2000);
           
           driver.findElement(By.id("logout_sidebar_link")).click();
           Thread.sleep(2000);

           String currentUrlAfterLogout = driver.getCurrentUrl();
           boolean logoutSuccess = currentUrlAfterLogout.equals("https://www.saucedemo.com/");
           System.out.println("Logout successful and redirected to Login Page: " + logoutSuccess);
           
        
        // Close the Browser
        driver.quit();

        
        
        
	
	
	
	
	
	
	}
}