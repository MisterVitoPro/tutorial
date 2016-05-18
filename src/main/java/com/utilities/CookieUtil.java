package com.utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Qa Automan on 5/9/2016.
 */
public class CookieUtil {

    public static void addCookieAndVerify(Cookie cookie, WebDriver driver){
        driver.get(cookie.getDomain());
        Assert.assertTrue(driver.manage().getCookieNamed(cookie.getName()) == null);
        //Add in the cookie
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        // Verify that language is set to English
        Assert.assertEquals(driver.manage().getCookieNamed(cookie.getName()).getValue(), cookie.getValue());
    }

}
