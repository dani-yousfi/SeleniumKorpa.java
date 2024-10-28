package Domaci021024;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class meme {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://imgflip.com/memegenerator");

    }

    @Test
    public void Test() throws InterruptedException {
        Thread.sleep(1000);
        WebElement uploadImage = driver.findElement(By.id("mm-show-upload"));

        uploadImage.click();
        Thread.sleep(1000);
        WebElement uploadImageButton = driver.findElement(By.id("mm-upload-file"));
        //  Thread.sleep(4000);
        String imageLocation = "C:\\Users\\admin\\Desktop\\download.png";
        uploadImageButton.sendKeys(imageLocation);

        WebElement dasda = driver.findElement(By.id("mm-upload-btn"));
        dasda.click();

        WebElement text = driver.findElement(By.cssSelector("textarea[placeholder='Top Text']"));
        text.sendKeys("Trenutna karijera");
        WebElement text1 = driver.findElement(By.cssSelector("textarea[placeholder='Bottom Text']"));
        text1.sendKeys("IT Bootcamp");
        WebElement button = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        button.click();


    }
}