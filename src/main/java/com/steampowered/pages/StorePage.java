package com.steampowered.pages;

import com.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by MisterVitoPro on 9/8/2015.
 */
public class StorePage extends BasePage {

    final String PAGE_URL = "http://store.steampowered.com/";
    final String PAGE_TITLE = "Welcome to Steam";

    @FindBy(css = ".home_page_gutter_block > a[href~='Free%20to%20Play']") private WebElement LINK_FREE_TO_PLAY;
    @FindBy(css = ".home_page_gutter_block > a[href~='Early%20Access']") private WebElement LINK_EARLY_ACCESS;
    @FindBy(css = ".home_page_gutter_block > a[href~='Action']") private WebElement LINK_ACTION;
    @FindBy(css = ".home_page_gutter_block > a[href~='Adventure']") private WebElement LINK_ADVENTURE;
    @FindBy(css = ".home_page_gutter_block > a[href~='Casual']") private WebElement LINK_CASUAL;
    @FindBy(css = ".home_page_gutter_block > a[href~='Indie']") private WebElement LINK_INDIE;
    @FindBy(css = ".home_page_gutter_block > a[href~='Massively%20Multiplayer']") private WebElement LINK_MASSIVE_MULTI;
    @FindBy(css = ".home_page_gutter_block > a[href~='Racing']") private WebElement LINK_RACING;
    @FindBy(css = ".home_page_gutter_block > a[href~='RPG']") private WebElement LINK_RPG;
    @FindBy(css = ".home_page_gutter_block > a[href~='Simulation']") private WebElement LINK_SIMULATION;
    @FindBy(css = ".home_page_gutter_block > a[href~='Sports']") private WebElement LINK_SPORTS;
    @FindBy(css = ".home_page_gutter_block > a[href~='Strategy']") private WebElement LINK_STRATEGY;
    @FindBy(css = ".home_page_gutter_block > .home_page_gutter_movies > a[href~='Movie']") private WebElement LINK_MOVIES;

    public StorePage(WebDriver driver) {
        super(driver);
    }



}
