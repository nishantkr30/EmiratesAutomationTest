package com.emirates.flight;

import com.emirates.flight.Repo.FlightPage;
import com.emirates.flight.StepDefs.Flight;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Nishant on 7/13/2018.
 */
public class Browser {

    private WebDriver driver;
    private Properties prop;
    private FlightPage flightpage;

    @Before
    public void setUp(){
        FileInputStream f = null;
        try{
            f = new FileInputStream(new File("C:/Workspace/EmiratesAutomationTest/src/test/Resources/com/emirates/flight/Config.properties"));

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        prop = new Properties();
        try{
            prop.load(f);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver","C://Workspace//EmiratesAutomationTest//src//test//Resources//com//emirates//flight//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        flightpage = new FlightPage(driver);

    }

    public WebDriver getDriver(){
        return driver;
    }

    public Properties getProp(){
        return prop;
    }

   public FlightPage getFlightPage(){
        return flightpage;
    }

    @After
    public void tearDown(){
//        driver.quit();
    }

}
