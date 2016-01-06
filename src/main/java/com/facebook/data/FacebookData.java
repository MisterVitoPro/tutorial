package com.facebook.data;

import org.testng.annotations.DataProvider;

/**
 * Created by MisterVitoPro on 9/25/2014.
 */
public class FacebookData {

    // Args: URL, TITLE OF PAGE
    @DataProvider(name = "pages")
    public static Object[][] pages(){
        return new Object[][] {
                {"http://www.facebook.com", "Welcome to Facebook - Log In, Sign Up or Learn More"},
                {"http://www.google.com", "Google"},
                {"http://www.yahoo.com", "Yahoo"}
        };
    }

    @DataProvider(name = "login")
    public static Object[][] login() {
        System.out.println("DATA PROVIDER");
        return new Object[][] {
                {"anthony.vito11@hotmail.com", "facebook", null},
                {"", "facebook", "Incorrect Email"},


        };
    }

    @DataProvider(name="signup")
    public static Object[][] signup(){
        return new Object[][] {
                {"QA", "Automan", "validEmail@facebook.com"},
                {"@#$%@#", "@#!#@$T%%%", "validEmail@facebook.com"},
                {"12341", "5234523", "validEmail@facebook.com"},
        };
    }
}
