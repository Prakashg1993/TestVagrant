package cukeRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features ="src/test/java/features",
        glue="stepDefinations",
        format= {"pretty","html:test-output"},
        monochrome= true ,
        tags= {"@tag1,@tag2"}
        )
		

public class testRunner extends AbstractTestNGCucumberTests {

}
