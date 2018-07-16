package com.emirates.flight.StepDefs;

import com.emirates.flight.Browser;
import com.emirates.flight.Hooks;
import com.emirates.flight.Repo.FlightPage;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by Nishant on 7/13/2018.
 */
public class Flight {
  WebDriver driver;
  Properties prop;
  Scenario scenario;
  public FlightPage flightPage;
  Browser browser;

  Hooks hooks = new Hooks();
public Flight(Browser browser){this.browser=browser;}
  @Before
    public void Before(Scenario scenario){this.scenario=scenario;}

    @Given("^that Bill has decided to check available flights$")
    public void ThatBillHasDecidedToCheckAvailableFlights(){
        driver = browser.getDriver();
        prop = browser.getProp();
        flightPage= browser.getFlightPage();
        driver.get(prop.getProperty("URL"));

    }
    @When("^he looks at a return trip from DXB to LHR leaving one week from now$")
    public void heLooksAtAReturnTripFromDXBToLHRLeavingOneWeekFromNow(){
        flightPage.departureAirport.clear();
        flightPage.departureAirport.sendKeys("DXB");
        flightPage.arrivalAirport.sendKeys("LHR");
        hooks.explicitWait(driver,30,flightPage.DepartureAirportdropdown);
        flightPage.DepartureAirportdropdown.click();
        flightPage.continueButton.click();
        flightPage.departureDateLabel.get(0).click();
        //  hooks.explicitWait(driver,20,flightPage.DepartureDate);
        try {
            Thread.sleep(2000);
            flightPage.DepartureDate.get(0).click();
            flightPage.Onewayselect.get(0).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hooks.explicitWait(driver,20,flightPage.SearchFlight);
        flightPage.SearchFlight.click();
    }

    @Then("^he should be shown the cheapest return ticket from DXB to LHR$")
    public void heShouldBeShownTheCheapestReturnTicketFromDXBToLHR(){

        List<String> listingPageFare = new ArrayList<String>(flightPage.listingPageFare.size());
        Collections.sort(listingPageFare);
        System.out.println(listingPageFare.get(0));
    }


}
