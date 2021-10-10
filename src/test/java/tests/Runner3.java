package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@target/failedtests.txt",
		glue="glue",
		monochrome=true,
		plugin={"pretty","html:target/retestres","rerun:target/failedretets.txt"}
		)
public class Runner3 extends AbstractTestNGCucumberTests
{
}
