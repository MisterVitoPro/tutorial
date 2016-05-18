package com.steampowered;

import com.WebBaseTest;
import com.steampowered.data.CookieData;
import com.utilities.CookieUtil;
import com.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static com.steampowered.data.CookieData.getCookieByLanguage;
import static com.steampowered.data.CookieData.languages;
import static com.utilities.DriverFactory.getDriver;

/**
 * Created by QA Automan on 4/25/2016.
 */
public class CookieTest extends WebBaseTest {

    String baseUrl;

    @BeforeClass
    public void setupCookies() throws Exception {
        baseUrl = "http://store.steampowered.com";
    }

    @BeforeMethod
    public void removeCookies(){
        driver.get(baseUrl);
        driver.manage().deleteAllCookies();
    }

    @Test(dataProvider = "steamCookies")
    public void addingLanguageCookie(Cookie cookie, String expectedLangString) throws Exception {
        CookieUtil.addCookieAndVerify(cookie, driver);
        //Assert that the language is English
        _wait.until(ExpectedConditions.textToBe(By.cssSelector("#language_pulldown"), expectedLangString));
    }

    @Test
    public void deleteSpanishCookieTakesYouBackToEnglish() throws Exception{
        Cookie es_Cookie = getCookieByLanguage("es");
        CookieUtil.addCookieAndVerify(getCookieByLanguage("es"), driver);
        //Assert that the language is Spanish
        _wait.until(ExpectedConditions.textToBe(By.cssSelector("#language_pulldown"), "idioma"));

        driver.manage().deleteCookieNamed(es_Cookie.getName());
        driver.navigate().refresh();

        //Assert that we are in English
        _wait.until(ExpectedConditions.textToBe(By.cssSelector("#language_pulldown"), "language"));
    }

    @Test
    public void dropDownToLanguage(){
        driver.get(baseUrl);

        // TODO create into Page Objects
        driver.findElement(By.cssSelector("#language_pulldown")).click();
        driver.findElement(By.cssSelector("a[href='?l=spanish']")).click();
        _wait.until(ExpectedConditions.textToBe(By.cssSelector("#language_pulldown"), "idioma"));

        Cookie languageCookie = driver.manage().getCookieNamed(CookieData.name);
        Assert.assertEquals(languageCookie.getValue(), languages.get("es"));
    }

}
 