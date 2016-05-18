package com;

import com.facebook.pages.FacebookLoginPage;
import com.facebook.pages.FacebookMainFeed;
import com.facebook.pages.FacebookMainPage;
import com.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.utilities.DriverFactory.getDriver;

/**
 * Created by Qa Automan on 5/8/2016.
 */
public class WebBaseTest {

    protected WebDriver driver;
    public WebDriverWait _wait;
    final int BASE_TIMEOUT_SECONDS = 5;

    @BeforeClass(groups="pageLoads")
    public void setupBeforeClass() throws Exception {
        // Create our webdriver instance
        driver = getDriver( DriverFactory.getBrowserTypeByProperty() );
        // Setup implicit driver wait
        driver.manage().timeouts().implicitlyWait(BASE_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        // Setup our explicit WebDriverWait
        _wait = new WebDriverWait(driver, BASE_TIMEOUT_SECONDS);
    }

    /**
     * Teardown our driver and tests in class
     */
    @AfterClass(alwaysRun = true)
    public void teardown(){
        this.driver.quit();
    }

}
