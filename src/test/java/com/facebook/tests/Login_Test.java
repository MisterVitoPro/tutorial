package com.facebook.tests;

import com.qaautoman.data.FacebookData;
import com.qaautoman.pages.FacebookLoginPage;
import com.qaautoman.pages.FacebookMainFeed;
import com.qaautoman.pages.FacebookMainPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOError;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login_Test {
	
	public WebDriver driver;
    FacebookMainPage fbMainPage;
    FacebookLoginPage fbLoginPage;
    FacebookMainFeed fbMainFeed;

	@BeforeClass(alwaysRun = true)
	public void setup(){
		this.driver = new FirefoxDriver();
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class );
        fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class );
        fbMainFeed = PageFactory.initElements(driver, FacebookMainFeed.class );
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		this.driver.quit();
	}

    @Test(groups={"p1", "pageLoads"})
    public void testTryCatchFinally()  {
        try{
            assertTrue(false);
            System.out.println("TRIED IT");
        }catch(AssertionError e){
            System.out.println("CAUGHT ME");
        }finally{
            driver.navigate().refresh();
        }
    }

	@Test(groups={"p1", "pageLoads"})
	public void loadPage()  {
        fbMainPage.loadPage();
    }
	
	@Test(groups={"p2", "field"}, dependsOnMethods="loadPage")
	public void filloutEmailFld() {
        fbMainPage.setText_EmailLogin("anthony.vito11@hotmail.com");
	}
	
	@Test(groups={"p2", "field"},dependsOnMethods="filloutEmailFld")
	public void filloutPassFld() {
        fbMainPage.setText_PasswordLogin("123456");
	}

    @Test(groups={"p1"}, dataProviderClass = FacebookData.class, dataProvider = "login")
    public void testLoginMainPage(String email, String password, String errorType) {
        driver.manage().deleteAllCookies();

        System.out.println("loadpage logineMain");
        fbMainPage.loadPage();
        fbMainPage.login(email, password);
        System.out.println("loaded the page. LoginMain");
        // Verify what to test based on data passed in
        if(!StringUtils.isBlank(errorType)){
            boolean result = fbLoginPage.checkErrorHeader(errorType);
            assertTrue(result, "Expected error: " + errorType);
        }else {
            assertTrue(!fbMainFeed.getUsernameText().isEmpty());
        }
    }

}
