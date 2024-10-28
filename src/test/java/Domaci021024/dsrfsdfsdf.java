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

public class dsrfsdfsdf {



    WebDriver driver;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");

    }

    @Test
    public void userCanLogIn() {

        Cookie cookie = new Cookie("userName", "MarkoStevanovic");
        Cookie cookie2 = new Cookie("userID", "40d10822-7cc0-4125-8c5d-5d22ca48f83a");
        Cookie cookie3 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmtvc3RldmFub3ZpYyIsInBhc3N3b3JkIjoiRmFjZXBybzIyMkAiLCJpYXQiOjE3MjgwNTU2NDJ9.-DBT8YZRCk1V2-mq9svmV3MV8gw6ORSKqnJ_RVou1Vc");
        Cookie cookie5 = new Cookie("expires", "2024-10-11T15%3A27%3A22.596Z");


        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie5);


        driver.navigate().refresh();

        WebElement logOutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutButton.isDisplayed());


    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/







}
