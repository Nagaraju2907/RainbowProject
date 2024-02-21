package stepdefination;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resuable.BaseCode;

import java.io.IOException;

public class Hooks extends BaseCode {

    @Before
    public void setUp() throws IOException {

        System.out.println("Execution started");

        BaseCode.launchBrowser();
    }

    @After
    public void tearDown(){

        System.out.println("Execution Ended");
       // driver.quit();
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("before step");
    }

    @AfterStep
    public void takeScreenshot(Scenario sc){

        System.out.println("Screenshot Taken");

       byte[] byteImage =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
       sc.attach(byteImage,"image/png",sc.getName());

    }


}
