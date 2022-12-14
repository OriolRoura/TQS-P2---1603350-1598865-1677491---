package defaultPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/pagaments.feature", glue="steps")
public class Pagaments extends AbstractTestNGCucumberTests{

}
