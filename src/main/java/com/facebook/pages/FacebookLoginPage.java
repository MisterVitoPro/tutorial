package com.facebook.pages;

import com.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

/**
 * Created by MisterVitoPro on 10/17/2014.
 */
public class FacebookLoginPage extends BasePage {

    public static final String PAGE_TITLE = "Facebook";
    public static final String PAGE_URL = "http://www.facebook.com/login.php";

    @FindBy(css = ".pam.login_error_box.uiBoxRed>div:first-child") WebElement errorHeader;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkErrorHeader(String text) {
        try{
            return errorHeader.getText().equals(text);
        }catch(NoSuchElementException e){
            return false;
        }
    }

}
