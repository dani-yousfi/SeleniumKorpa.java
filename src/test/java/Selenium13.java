import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium13 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Ulogovati se na wordpress site
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/");

        WebElement loginPageButton = driver.findElement(By.linkText("Log in"));
        loginPageButton.click();

        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();

        String username = "dani-yousfi@live.com";
        usernameField.sendKeys(username);

        WebElement continueLogInButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueLogInButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        String password = "Bootcamp123!";
        Thread.sleep(3000);
        passwordField.sendKeys(password);

        WebElement logInButton = driver.findElement(By.className("login__form-action"));
        logInButton.click();

        Thread.sleep(5000);
        WebElement howdy = driver.findElement(By.className("masterbar__item-howdy-howdy"));
        Assert.assertTrue(howdy.isDisplayed());


        //WebElement logOutButton = driver.findElement(By.className("button is-link"));
        //logOutButton.click();
}
}
