package Domaci021024;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LogInSaValidnimUsernameomBezSifre {
    public static void main(String[] args) throws InterruptedException {

        //Test case log in sa

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.saucedemo.com");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));



        String validUsername = "standard_user";

        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        loginButton.click();

        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);


        WebElement unsuccessfulLoginMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
        Assert.assertTrue(unsuccessfulLoginMessage.isDisplayed());

        String actualUnsuccessfulLoginMessage= unsuccessfulLoginMessage.getText();
        String expectedUnsuccessfulLoginMessageText = "Epic sadface: Password is required";

        Assert.assertEquals(actualUnsuccessfulLoginMessage,expectedUnsuccessfulLoginMessageText);
    }
}
