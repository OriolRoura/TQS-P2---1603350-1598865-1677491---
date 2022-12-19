import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Company.feature", glue="steps")
public class Company extends AbstractTestNGCucumberTests{
