package com.facebook.pages;

import com.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by MisterVitoPro on 10/17/2014.
 */
public class FacebookMainFeed extends BasePage {

    @FindBy(css = ".fbxWelcomeBoxName") WebElement link_WelcomeUsername;

    public FacebookMainFeed(WebDriver driver) {
        super(driver);
    }

    public String getUsernameText(){
        return link_WelcomeUsername.getText();
    }

}
