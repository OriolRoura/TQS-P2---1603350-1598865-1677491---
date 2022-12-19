package defaultPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/mouresAndLogout.feature", glue="steps")
public class mouresAndLogoutTest extends AbstractTestNGCucumberTests{

}
