package com.emirates.flight.Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Nishant on 7/13/2018.
 */
public class FlightPage {
    public FlightPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

@FindBy(how= How.NAME,using="Departure airport")
public WebElement departureAirport;

@FindBy(how=How.NAME,using = "Arrival airport")
public WebElement arrivalAirport;

@FindBy(how=How.XPATH,using = "//a[@class='cta cta--large cta--primary js-continue-search-flight search-flight__continue--cta ']")
public WebElement continueButton;

@FindBy(how=How.XPATH,using = "//div[@class='textfield__controls']/div[1]/label[1]")

public java.util.List<WebElement> departureDateLabel;

@FindBy(how=How.XPATH,using = "//td[@data-date='24']")

public java.util.List<WebElement> DepartureDate;

@FindBy(how=How.XPATH,using = "//td[@data-date='25']")

public java.util.List<WebElement> ArrivalDate;

@FindBy(how=How.XPATH,using = "//input[@class='checkbox__input js-one-way control__one-way']")

public java.util.List<WebElement> Onewayselect;

@FindBy(how=How.XPATH,using = "//button[@class='cta cta--large cta--primary js-widget-submit ']")

public WebElement SearchFlight;

@FindBy(how=How.XPATH,using = "//div[@class='destination-dropdown']/div[2]/section/ol/li[1]")

public WebElement DepartureAirportdropdown;

@FindBy(how=How.XPATH,using= "//div[@class='ts-fbr-option__price-detail']")

public java.util.List<WebElement> listingPageFare;

}
