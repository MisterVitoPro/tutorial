package com.facebook.tests;

import com.facebook.pages.FacebookMainPage;
import com.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.utilities.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Created by MisterVitoPro on 10/21/2014.
 */
public class SignUp_Test {

    public WebDriver driver;
    public WebDriverWait wait;
    FacebookMainPage fbMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = getDriver( DriverFactory.getBrowserTypeByProperty() );
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        this.driver.quit();
    }

    @Test(groups={"p1"}, enabled = false)
    public void testSignUpMainPage(){
        driver.manage().deleteAllCookies();

        fbMainPage.loadPage();
        fbMainPage.setText_FirstNameField("QA");
        fbMainPage.setText_LastNameField("Automan");
        fbMainPage.setText_EmailMobileField("validEmail@qaautoman.com");
        fbMainPage.setText_ReenterEmailMobileField("validEmail@qaautoman.com");
        fbMainPage.setText_PasswordField("password");

        fbMainPage.selectBdayMonth("8");
        fbMainPage.selectBdayDay("20");
        fbMainPage.selectBdayYear("1990");
        fbMainPage.click_MaleRadio();
        //fbMainPage.click_SignUpButton(); // commented out to stop sign-up
    }

}
