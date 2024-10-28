import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium11 {
    public static void main(String[] args) {
        /*
        Uraditi test case-eve za login stranice
        https://practicetestautomation.com/
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        // Ako imamo na elementu href uz neki string, taj string mozemo da koristimo kao lokator preko linkText
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String inValidUsername = "incorrectUser";
        String validPassword = "Password123";

        // Uzimamo trenutni URL jer cemo kasnije proveriti da li se URL promenio
        String loginPageURL = driver.getCurrentUrl();

        // Kada radimo sa poljima treba prvo da pozovemo akciju .clear() da bismo ocistili polje pre unosa
        // Na ovaj nacin ne rizikujemo ako u poljima je nesto ostalo upisano
        usernameField.clear();
        usernameField.sendKeys(inValidUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        // Sad nam je koristan string iz 35. reda jer proveravam nakon logovanja da li je link promenjen
        //Assert.assertNotEquals(driver.getCurrentUrl(), loginPageURL);
        // A zatim proveravam da li je link ispravan
        //Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        //WebElement logOutButton = driver.findElement(By.linkText("Log out"));

        //Assert.assertTrue(logOutButton.isDisplayed());

        WebElement unsucessfullLogIn = driver.findElement(By.id("error"));
        String unsucessfullLogInText = unsucessfullLogIn.getText();

        // Posto u poruci nakon logovanja stoji username, mogu da iskoristim tu poruku na sledeci nacin
        // da mi testovi prolaze sa svakim nalogom koji koristim
        Assert.assertEquals(unsucessfullLogInText, "Your username is invalid!");

    }
}
