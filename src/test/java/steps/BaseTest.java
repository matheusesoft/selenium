package steps;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import core.DriverFactory;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import utils.FeatureOverright;
import utils.Propriedades;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	private WebDriver driver;
	
	@Before
	public void launchBrowser() throws InvalidFormatException, IOException {
		this.driver = DriverFactory.getDriver();
		String url = Propriedades.getInstance().getProperty("url");
		this.driver.get(url);
		this.driver.manage().window().maximize();
	}

	@After
	public void closeBrowser(Scenario cenario) throws IOException  {
		if(cenario.isFailed())
		{
			cenario.write("Cenário falhou!");
		}
		else
		{
			cenario.write("Cenário executado com sucesso!");
		}
		
		cenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
		
	}
	
	@BeforeStep
    public void beforeStep(Scenario cenario) {
    }

    @AfterStep
    public void afterStep(Scenario cenario) {
		cenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
    }
		
}
