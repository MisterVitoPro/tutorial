package com.facebook.tests;

import com.qaautoman.pages.FacebookLoginPage;
import com.qaautoman.pages.FacebookMainFeed;
import com.qaautoman.pages.FacebookMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by MisterVitoPro on 10/21/2014.
 */
public class SignUp_Test {

    public WebDriver driver;
    FacebookMainPage fbMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        this.driver.quit();
    }

    @Test(groups={"p1"})
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
        fbMainPage.click_SignUpButton();
    }

}
