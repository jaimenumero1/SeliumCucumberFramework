package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(){
        Driver.close();
    }
}
