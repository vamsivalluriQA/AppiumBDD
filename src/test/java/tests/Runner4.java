package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//We need to add @Regression tag to prevoiusly passed scenarios
@CucumberOptions(
		features="src\\test\\resources\\features",
		glue="glue",
		tags="@Regression",
		monochrome=true,
		plugin={"pretty","html:target/regressiontestres","rerun:target/failedregression.txt"}
		)
public class Runner4 extends AbstractTestNGCucumberTests
{
}





