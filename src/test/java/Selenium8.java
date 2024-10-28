import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium8 {
    public static void main(String[] args) {

        /*
        //Zadatak 3
//Otici na Google
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola Tesla"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        WebElement searchBoxByID = driver.findElement(By.id("APjFqb"));

        WebElement searchWikipediaByID = driver.findElement(By.id("gsr"));

        searchBoxByID.sendKeys("Wikipedia");

        searchBoxByID.sendKeys(Keys.ENTER);

        searchWikipediaByID.click();



    }
}
