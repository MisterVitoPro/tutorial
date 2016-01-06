package com.facebook.tests;

import com.facebook.data.FacebookData;
import com.facebook.pages.FacebookLoginPage;
import com.facebook.pages.FacebookMainFeed;
import com.facebook.pages.FacebookMainPage;
import com.utilities.DriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static com.utilities.DriverFactory.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login_Test {
	
	public WebDriver driver;
    //FacebookMainPage fbMainPage;
    FacebookMainPage fbMainPage;
    FacebookLoginPage fbLoginPage;
    FacebookMainFeed fbMainFeed;

	@BeforeClass(alwaysRun = true)
	public void setup(){
		this.driver = getDriver( DriverFactory.getBrowserTypeByProperty() );
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class );
        fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class );
        fbMainFeed = PageFactory.initElements(driver, FacebookMainFeed.class );
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		this.driver.quit();
	}

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BEFORE METHOD");
    }

	@Test(groups={"p1", "pageLoads"})
	public void loadPage() {
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
        driver.get("http://www.google.com");
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
