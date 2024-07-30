package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    // TestNG WebDriver objesini bize dondurecek getDriver() ile WebDriver objesi olusturur

    public static WebDriver driver;

    public static WebDriver getDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }
}
