package com.emirates.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nishant on 7/13/2018.
 */
public class Hooks {

    public void explicitWait(WebDriver driver, int time, WebElement element){
        (new WebDriverWait(driver, time)).until(ExpectedConditions.visibilityOf(element));

    }
}
