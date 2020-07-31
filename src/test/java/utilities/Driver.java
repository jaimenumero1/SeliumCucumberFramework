package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 * 1. Declare constructor of class as private so that no one instantiate class outside of it.
 * 2. Declare a private static reference variable of Webdriver. Static is needed to make it available globally.
 * 3. Declare a static method getDriver() with returns an instance of a ChromeDriver type which should check if instance is already instantiated once.
 * 4. Make sure getDriver() method returns maximized browser window and add implicit wait
 * */

public class Driver {
    //TODO: Implement here

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){

        if(driver==null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;

    }
}
