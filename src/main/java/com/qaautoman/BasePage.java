package com.qaautoman;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by MisterVitoPro on 10/23/2014.
 */
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public String PAGE_URL;
    public String PAGE_TITLE;

    public BasePage(WebDriver driver){
        this.driver = driver;
        jsExecutor = ((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, 5);
    }

    public void loadPage(){
        driver.get(getPageUrl());
        Assert.assertEquals(driver.getTitle(), getPageTitle());
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void selectValueInDropdown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public String getPageUrl(){
        return PAGE_URL;
    }

    public String getPageTitle(){
        return PAGE_TITLE;
    }

}
