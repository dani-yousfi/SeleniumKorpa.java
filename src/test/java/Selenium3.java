import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;

public class Selenium3 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        driver.navigate().to("https://rs.linkedin.com/");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        System.out.println("Lista tabova je" + listaTabova);

        driver.switchTo().window(listaTabova.get(1));

        driver.navigate().to("https://rs.linkedin.com/");

        driver.switchTo().window(listaTabova.get(2));

        driver.navigate().to("https://www.facebook.com/");

        driver.close();

    }
}
