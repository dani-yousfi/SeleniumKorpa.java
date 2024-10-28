package Domaci021024;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DomaciCookies {

    WebDriver driver;
   // WebDriverWait wait;


    @BeforeClass

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/books");

    }

    @Test
    public void Test()  {
        Cookie cookie = new Cookie("userName","danidani");
        Cookie cookie1 = new Cookie("userID","5f81e1e3-3dfc-42d7-9acb-502a1a154957");
        Cookie cookie2 = new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRhbmlkYW5pIiwicGFzc3dvcmQiOiJEYW5pMTIzISIsImlhdCI6MTcyODAzNTg3M30.YX7w-FhApbnyXwm7uTwgmS7pzRKC59wM_lNzYgGrCoI");
        Cookie cookie3 = new Cookie("expires","2024-10-11T09%3A57%3A53.637Z");
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.navigate().refresh();
        WebElement logoutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
