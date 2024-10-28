import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium7 {

    public static void main(String[] args) {





        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.navigate().to("https://www.google.com/");

        // LOKATORI / SELEKTORI

        // ID - Prvi po hijerarhiji, u idealnoj situaciji je jedinstven
        WebElement searchBoxByID = driver.findElement(By.id("APjFqb"));

        // NAME - Drugi po hijearhiji, cesto je jedinstven
        WebElement searchBoxByName = driver.findElement(By.name("q"));

        // Class
        WebElement searchBoxByClass = driver.findElement(By.className("gLFyf"));

        // CSS Selector
        // Formula za CSS Selector - WebElement searchBoxByCSS = driver.findElement(By.cssSelector("tag[atribut='vrednost atributa']"));
        WebElement searchBoxByCSS = driver.findElement(By.cssSelector("textarea[role='combobox']"));

        // Relative Xpath
        WebElement searchBoxByRelativeXpath = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));

        // Full Xpath - Najnestabilniji lokator
        WebElement searchBoxByFullXpath = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));

        //------------------------------

        searchBoxByID.sendKeys("Wikipedia");

        searchBoxByID.sendKeys(Keys.ENTER);


    }

}
