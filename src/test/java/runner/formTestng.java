package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
 @io.cucumber.testng.CucumberOptions(features = {"src\\test\\resources\\SimpleForm\\form.feature"}
,glue = "formfillup")
 


 
public class formTestng extends AbstractTestNGCucumberTests{

}
