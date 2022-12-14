package defaultPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/reservaHotel.feature", glue="steps")
public class reservaTest extends AbstractTestNGCucumberTests{

}