package com.facebook.tests;

import com.qaautoman.data.FacebookData;
import com.qaautoman.pages.FacebookMainPage;
import com.qaautoman.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.qaautoman.utilities.DriverFactory.getDriver;

/**
 * Created by MisterVitoPro on 10/21/2014.
 */
public class SignUp_Flow_Test {

    public WebDriver driver;
    public WebDriverWait wait;
    FacebookMainPage fbMainPage;

    HashMap<String, String> signUpMap;

    @Factory(dataProvider = "signup", dataProviderClass = FacebookData.class)
    public SignUp_Flow_Test(String first, String last, String email){
        signUpMap = new HashMap<String, String>();
        signUpMap.put("firstname", first);
        signUpMap.put("lastname", last);
        signUpMap.put("email", email);
    }

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

    @Test
    public void loadSignUpMainPage(){
        fbMainPage.loadPage();
        driver.manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "loadSignUpMainPage")
    public void signUpMainPageFirstNameField(){
        fbMainPage.setText_FirstNameField(signUpMap.get("firstname"));
    }

    @Test(dependsOnMethods = "signUpMainPageFirstNameField")
    public void signUpMainPageLastNameField(){
        fbMainPage.setText_LastNameField(signUpMap.get("lastname"));
    }

    @Test(dependsOnMethods = "signUpMainPageLastNameField")
    public void signUpMainPageEmailMobileField(){
        fbMainPage.setText_EmailMobileField(signUpMap.get("email"));
    }

}
