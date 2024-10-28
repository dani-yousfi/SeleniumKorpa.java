package Domaci021024;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumKorpa {
    public static void main(String[] args) throws InterruptedException {

        /*
        https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
Testirati dodavanje knjige u korpu. i da li se knjiga obrise kada obrisete kolacice
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();


        WebElement addedToCartMessage = driver.findElement(By.cssSelector(".a-section.a-padding-medium.sw-atc-message-section"));
        Assert.assertTrue(addedToCartMessage.isDisplayed());

        WebElement itemNumberinCart = driver.findElement(By.id("nav-cart-count"));

        int expectedItemQuantity = 1;
        int actualItemQuantity = Integer.parseInt(itemNumberinCart.getText());

        Assert.assertEquals(actualItemQuantity, expectedItemQuantity);

        WebElement cartButton = driver.findElement(By.id("nav-cart-count-container"));
        cartButton.click();

        WebElement itemName = driver.findElement(By.className("a-truncate-cut"));

        Assert.assertTrue(itemName.isDisplayed());


        WebElement deleteButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[2]/span/input"));


        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        boolean isPresent = false;
        try {
            isPresent = deleteButton.isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertFalse(isPresent);

        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".a-size-large.a-spacing-top-base.sc-your-amazon-cart-is-empty"));

        String actualEmptyCartMessageText = emptyCartMessage.getText();
        String expectedEmptyCartMessageText = "Your Amazon Cart is empty";

        Assert.assertEquals(actualEmptyCartMessageText, expectedEmptyCartMessageText);

        WebElement emptyZeroCart = driver.findElement(By.className("nav-cart-count"));

        String zeroItemsInCart = emptyZeroCart.getText();
        String expectedZeroItemsInCart = String.valueOf(0);


        Assert.assertEquals(zeroItemsInCart, expectedZeroItemsInCart);

        emptyZeroCart.click();

        String expectedUrl = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
        String acturalUrl = driver.getCurrentUrl();

        Assert.assertEquals(acturalUrl, expectedUrl);


    }
}
