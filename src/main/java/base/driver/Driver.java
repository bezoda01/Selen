package base.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static base.Loggerr.*;
import static base.Settings.*;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getInstance();
        }
        return driver;
    }

    private static WebDriver getInstance() {
        switch (settings.get("browserName").toString()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                log("Create chrome driver");
                return new ChromeDriver(new DriverOptions().getOptions());
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                log("Create firefox driver");
                return new FirefoxDriver(new DriverOptions().getOptions());
            }
            default: {
                log("This browser do not support: \nsupport browser list: chrome opera firefox");
                throw new IllegalArgumentException();
            }
        }
    }
}
