import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium15 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com");
    }

    @Test(priority = 10)
    public void loginValidUsernameValidPassword() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        loginButton.click();
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        Assert.assertTrue(logoutButton.isDisplayed());


    }

    @Test(priority = 20)
    public void loginValidUsernameInvalidPassword() {

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        String validUsername = "standard_user";
        String invalidPassword = "secret_sauce1";
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(invalidPassword);
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector(".input_error.form_input.error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test(priority = 30)
    public void logOut() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        loginButton.click();
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        boolean isPresent = false;
        try {
            isPresent = logoutButton.isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(isPresent);

    }




}


