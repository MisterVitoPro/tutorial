package com.facebook.pages;

import com.BasePage;
import com.utilities.MyWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.Assert;

/**
 * Created by MisterVitoPro on 9/28/2014.
 */
public class FacebookMainPage extends BasePage {

    String propertiesPath = "facebookMainPageLocators.properties";

    final String EMAIL_LOGIN = "#email";
    final String EMAIL_PASSWORD = "#pass";
    final String EMAIL_FIRSTNAME = "#loginbutton>input";

    @FindBy(css = EMAIL_LOGIN) protected WebElement field_EmailLogin;
    @FindBy(css = EMAIL_PASSWORD) WebElement field_PasswordLogin;
    @FindBy(css = EMAIL_FIRSTNAME) WebElement button_Login;
    @FindBy(name = "firstname") WebElement field_FirstNameSignUp;
    @FindBy(name = "lastname") WebElement field_LastNameSignUp;
    @FindBy(name = "reg_email__") WebElement field_EmailMobileSignUp;
    @FindBy(name = "reg_email_confirmation__") WebElement field_ReenterEmailMobileSignUp;
    @FindBy(name = "reg_passwd__") WebElement field_PasswordSignUp;
    @FindBy(id = "month") WebElement dropdown_Month;
    @FindBy(id = "day") WebElement dropdown_Day;
    @FindBy(id = "year") WebElement dropdown_Year;
    @FindBy(css = "span+span input[name='sex']") WebElement radio_Male;
    @FindBy(css = "button[name='websubmit']") WebElement button_SignUp;

    public FacebookMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Facebook - Log In or Sign Up";
        this.PAGE_URL = "http://www.facebook.com";
    }

    public void login(String email, String password){
        wait.until(MyWaits.visibilityOfElement(field_EmailLogin));
        setText_EmailLogin(email);
        setText_PasswordLogin(password);
        clickLoginMain();
    }

    public void setText_EmailLogin(String text){
        System.out.println("FB MAIN");
        setElementText(field_EmailLogin, text);
    }

    public void setText_PasswordLogin(String text){
        setElementText(field_PasswordLogin, text);
    }

    public void clickLoginMain(){
        clickElement(button_Login);
    }

    public void setText_FirstNameField(String text){
        field_FirstNameSignUp.sendKeys(text);
        Assert.assertEquals(field_FirstNameSignUp.getAttribute("value"), text);
    }

    public void setText_LastNameField(String text){
        field_LastNameSignUp.sendKeys(text);
        Assert.assertEquals(field_LastNameSignUp.getAttribute("value"), text);
    }

    public void setText_EmailMobileField(String text){
        field_EmailMobileSignUp.sendKeys(text);
        Assert.assertEquals(field_EmailMobileSignUp.getAttribute("value"), text);
    }

    public void setText_ReenterEmailMobileField(String text){
        field_ReenterEmailMobileSignUp.sendKeys(text);
        Assert.assertEquals(field_ReenterEmailMobileSignUp.getAttribute("value"), text);
    }

    public void setText_PasswordField(String text){
        field_PasswordSignUp.sendKeys(text);
        Assert.assertEquals(field_PasswordSignUp.getAttribute("value"), text);
    }

    public void selectBdayMonth(String value) {
        selectValueInDropdown(dropdown_Month, value);
    }

    public void selectBdayDay(String value) {
        selectValueInDropdown(dropdown_Day, value);
    }

    public void selectBdayYear(String value) {
        selectValueInDropdown(dropdown_Year, value);
    }

    public void click_MaleRadio(){
        clickElement(radio_Male);
    }

    public void click_SignUpButton(){
        clickElement(button_SignUp);
    }

}
