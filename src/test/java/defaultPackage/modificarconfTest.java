package defaultPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/modificarconf.feature", glue="steps")
public class modificarconfTest extends AbstractTestNGCucumberTests{

}
