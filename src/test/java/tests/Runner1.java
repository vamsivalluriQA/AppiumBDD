package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//We need to add @smoketest tag to scenarios belongs to basic fumnctionality
@CucumberOptions(
		features="src\\test\\resources\\features",
		glue="glue",
		tags="@smoketest",
		monochrome=true,
		plugin={"pretty","html:target/smoketestres.html","rerun:target/failedsmoke.txt"}
		)
public class Runner1 extends AbstractTestNGCucumberTests
{
}





