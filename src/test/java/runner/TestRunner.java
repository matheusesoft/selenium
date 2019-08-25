package runner;

import static core.DriverFactory.killDriver;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import utils.FeatureOverright;
import utils.Propriedades;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "test.features",
        glue = "steps",
        tags= "@CT01, @CT02",
        plugin = {"html:target/cucumber-report, pretty"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true
        )   
public class TestRunner {
	
	@AfterClass
	public static void After() throws InvalidFormatException, IOException {
		if(!Propriedades.getInstance().getProperty("KILL").equals("FECHAR_BROWSER")) {
			killDriver();
		}
   }
}
 