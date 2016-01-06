package com.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by MisterVitoPro on 1/5/2016.
 */
public class MyWaits {

    public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isDisplayed();
                }catch (NoSuchElementException e){
                    return false;
                } catch (StaleElementReferenceException e1){
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> wait(final Boolean condition){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return condition;
            }
        };
    }

}
