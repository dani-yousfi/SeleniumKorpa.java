import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.Delayed;

public class Selenium9 {
    public static void main(String[] args) {

        /*
        // Zadatak 5
// Testirati log in stranice https://practicetestautomation.com/
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");
        WebElement padajuciMeni = driver.findElement(By.id("menu-item-20"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        padajuciMeni.click();
        WebElement freeCourse = driver.findElement(By.className("wp-block-column is-layout-flow wp-block-column-is-layout-flow"));
        freeCourse.click();
    }
}
