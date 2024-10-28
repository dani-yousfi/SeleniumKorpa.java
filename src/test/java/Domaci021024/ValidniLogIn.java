package Domaci021024;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ValidniLogIn {
    public static void main(String[] args) {

        /*
        Domaci
Testirati bar 3 razlicita test case-a za logovanje na sledecem linku:
https://www.saucedemo.com
*/

        //Test case validni login

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.saucedemo.com");

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

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

        WebElement hamburgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(hamburgerMenu.isDisplayed());

        WebElement shoppingCartButton = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(shoppingCartButton.isDisplayed());

    }
}
