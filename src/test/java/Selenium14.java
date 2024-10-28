import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Selenium14 {
    public static void main(String[] args) {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","daniyousfi%7C1822583951%7CubIXntWGhxdylFAzAtq7hS5K14ItzebO7IqXL1jdeQC%7Cc059c97e05329767faaab8e68e8566d0a62dae8d2c52941376f6cd25a79c6ebd");

        driver.manage().addCookie(cookie);

        driver.navigate().refresh();
    }
}
