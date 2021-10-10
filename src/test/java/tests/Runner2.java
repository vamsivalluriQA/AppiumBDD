package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\test\\resources\\features",
		glue="glue",
		monochrome=true,
		plugin={"pretty","html:target/realtestres","rerun:target/failedrealtests.txt"}
		)
public class Runner2  extends AbstractTestNGCucumberTests
{
}
