package com.qaautoman.data;

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
        return new Object[][] {
                {"anthony.vito11@hotmail.com", "123456", null},
                {"", "123456", "Incorrect Email"},


        };
    }
}
