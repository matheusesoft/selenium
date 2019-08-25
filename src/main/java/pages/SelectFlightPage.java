package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.DriverFactory.getDriver;

public class SelectFlightPage extends BasePage {
	
	private By outFlight = By.name("outFlight");
	private By inFlight = By.name("inFlight");
	private By btnContinue = By.name("reserveFlights");
	
	public String sOutFlight;
	public String sInFlight;
	
	public boolean verificarPagina() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public void selecionarOutFlight(String vooOut) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.outFlight));
		WebElement elementSelecionado = null;
		String[] voo;
		for (WebElement element : getDriver().findElements(this.outFlight)) {
			voo = element.getAttribute("value").split("\\$");
			String vooNome = voo[0]+" "+voo[1];
			if(vooNome.equals(vooOut))
			{
				elementSelecionado = element;
				break;
			}
		}
		sOutFlight = elementSelecionado.getAttribute("value");		
		elementSelecionado.click();
	}
	
	public void selecionarInFlight(String vooIn) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.inFlight));
		WebElement elementSelecionado = null;
		String[] voo;
		for (WebElement element : getDriver().findElements(this.inFlight)) {
			voo = element.getAttribute("value").split("\\$");
			String vooNome = voo[0]+" "+voo[1];
			if(vooNome.equals(vooIn))
			{
				elementSelecionado = element;
				break;
			}
		}
		sInFlight = elementSelecionado.getAttribute("value");		
		elementSelecionado.click();
	}
		
	public void clicarBtnContinue() {
		clicarBotao(btnContinue);
	}

}
