package com.steampowered.data;

import org.openqa.selenium.Cookie;
import org.testng.annotations.DataProvider;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Qa Automan on 5/9/2016.
 */
public class CookieData {

    public final static String name = "Steam_Language";
    public final static String path = "/";
    public final static String domain = "store.steampowered.com";

    @DataProvider(name = "steamCookies")
    public static Object[][] steamCookies(){
        return new Object[][] {
                {getCookieByLanguage("en"), "language"},
                {getCookieByLanguage("es"), "idioma"},
        };
    }

    public static Cookie getCookieByLanguage(String langCode){
        Date someDate = new Date();
        someDate.setTime(System.currentTimeMillis()+60000);
        return new Cookie(name, languages.get(langCode), domain, "/", someDate);
    }

    public static final HashMap<String, String> languages = new HashMap<String, String>() {{
        put("en", "english");
        put("es", "spanish");
    }};

}
