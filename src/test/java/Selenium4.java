import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.ArrayList;

public class Selenium4 {
    public static void main(String[] args) {
        /*
        //Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.rs");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> lista = new ArrayList<>(driver.getWindowHandles());

        System.out.println(lista);

        driver.switchTo().window(lista.get(1));
        driver.navigate().to("https://www.youtube.com");

        driver.switchTo().window(lista.get(2));
        driver.navigate().to("https://www.facebook.com");

        driver.switchTo().window(lista.get(3));
        driver.navigate().to("https://www.instagram.com");

        driver.switchTo().window(lista.get(4));
        driver.navigate().to("https://www.blic.rs");

        driver.switchTo().window(lista.get(5));
        driver.navigate().to("https://www.yahoo.com");

        driver.close();
        driver.switchTo().window(lista.get(4));
        driver.close();
        driver.switchTo().window(lista.get(3));
        driver.close();
        driver.switchTo().window(lista.get(2));
        driver.close();
        driver.switchTo().window(lista.get(1));
        driver.close();


    }
}
