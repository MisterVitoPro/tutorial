package com.qaautoman.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.qaautoman.utilities.DriverFactory.BrowserType.*;

/**
 * Created by MisterVitoPro on 5/12/2015.
 */
public class DriverFactory {

    public enum BrowserType {
        FIREFOX,
        CHROME,
        IE,
        SAFARI
    }

    public static WebDriver getDriver(BrowserType type){
        WebDriver driver = null;
        switch(type){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

}
