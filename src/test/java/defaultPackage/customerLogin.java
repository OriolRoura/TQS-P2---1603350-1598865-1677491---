package defaultPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/customerLogin.feature", glue="steps")
public class customerLogin extends AbstractTestNGCucumberTests{

}