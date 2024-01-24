package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// step 1 @Runwith
// step 2 @cucumberOptions

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src\\test\\resources\\login\\login.feature"}
,glue = "StepDefination"
,plugin = {"html:testoutput/cucumber.html","junit:testoutput/cucumber.xml","json:testoutput/cucumberjason.xml"}
)


public class TestRunner {
    
	
}
