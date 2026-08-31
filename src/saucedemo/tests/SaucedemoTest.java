package saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaucedemoTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		//2. "logo" // التحقق من ظهور شعار الموقع وقراءة نصه
		boolean logoDisplayed=driver.findElement(By.cssSelector("div.login_logo")).isDisplayed();
		String logoText = driver.findElement(By.cssSelector("div.login_logo")).getText();

		System.out.println("Logo is displayed: " + logoDisplayed);
		System.out.println("Logo text is: " + logoText);
	   //3.التحقق من ظهور حقول الإدخال وزر الدخول
		boolean usernameDisplayed = driver.findElement(By.id("user-name")).isDisplayed();
        boolean passwordDisplayed = driver.findElement(By.id("password")).isDisplayed();
        boolean loginButtonDisplayed = driver.findElement(By.id("login-button")).isDisplayed();
        
        System.out.println("Username field is displayed: " + usernameDisplayed);
        System.out.println("Password field is displayed: " + passwordDisplayed);
        System.out.println("Login button is displayed: " + loginButtonDisplayed);
		//4 ادخال باس ويوزر صحيحات 
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //5
        driver.findElement(By.id("login-button")).click();

        //6
     // التحقق من نجاح تسجيل الدخول والانتقال لصفحة المنتجات
        String currentUrl = driver.getCurrentUrl();
        boolean loginSuccess = currentUrl.contains("inventory.html");
        System.out.println("Login successful and redirected to inventory: " + loginSuccess);
     // إغلاق المتصفح
        driver.quit();
        
        
        
	
	
	
	
	
	
	}
}