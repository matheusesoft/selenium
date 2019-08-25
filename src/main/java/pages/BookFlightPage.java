package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.DriverFactory.getDriver;

public class BookFlightPage extends BasePage {
	
	private By dayOutFlight = By.name("fromDay");
	private By monthOutFlight = By.name("fromMonth");
	private By nomeOutFlight = By.name("outFlightName");
	private By numberOutFlight = By.name("outFlightNumber");
	private By priceOutFlight = By.name("outFlightPrice");
	private By timeOutFlight = By.name("outFlightTime");
	
	private By dayInFlight = By.name("toDay");
	private By monthInFlight = By.name("toMonth");
	private By numberInFlight = By.name("inFlightNumber");
	private By nomeInFlight = By.name("inFlightName");
	private By priceInFlight = By.name("inFlightPrice");
	private By timeInFlight = By.name("inFlightTime");
	
	private By servClass = By.name("servClass");
	private By subtotal = By.name("subtotal");
	private By taxes = By.name("taxes");	
	
	private By impress = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[1]/img");
	private By firstName = By.name("passFirst0");
	private By lastName = By.name("passLast0");
	private By btnContinue = By.name("buyFlights");
	private By cc_frst_name = By.name("cc_frst_name");
	private By numeroCartao = By.name("creditnumber");
	
	public boolean verificarPagina() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean verificarOrdemGerada() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(impress));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public void escreveNome(String firstName)
	{
		escrever(this.firstName, firstName);
	}
	
	public void escreveUltimoNome(String lastName)
	{
		escrever(this.lastName, lastName);
	}
	
	public void escreveNumeroCartao(String nroCartao)
	{
		escrever(numeroCartao, nroCartao);
	}
	
	public void escreveNomePassageiro(String passageiroNome)
	{
		escrever(cc_frst_name, passageiroNome);
	}
	
	public String getDataOutFlight()
	{
		return getDriver().findElement(dayOutFlight).getAttribute("value") +"/"+getDriver().findElement(monthOutFlight).getAttribute("value");
	}
	
	public String getNomeOutFlight()
	{
		return getDriver().findElement(nomeOutFlight).getAttribute("value") + " " +getDriver().findElement(numberOutFlight).getAttribute("value");
	}
	
	public String getPriceOutFlight()
	{
		return getDriver().findElement(priceOutFlight).getAttribute("value");
	}
	
	public String getTimeOutFlight()
	{
		return getDriver().findElement(timeOutFlight).getAttribute("value");
	}
	
	public String getDataInFlight()
	{
		return getDriver().findElement(dayInFlight).getAttribute("value") +"/"+getDriver().findElement(monthInFlight).getAttribute("value");
	}
	
	public String getNomeInFlight()
	{
		return getDriver().findElement(nomeInFlight).getAttribute("value") + " " +getDriver().findElement(numberInFlight).getAttribute("value");
	}
	
	public String getPriceInFlight()
	{
		return getDriver().findElement(priceInFlight).getAttribute("value");
	}
	
	public String getTimeInFlight()
	{
		return getDriver().findElement(timeInFlight).getAttribute("value");
	}
	
	public String getServClass()
	{
		return getDriver().findElement(servClass).getAttribute("value");
	}
	
	public String getTaxas()
	{
		return getDriver().findElement(taxes).getAttribute("value");
	}
	
	public String getSubtotal()
	{
		return getDriver().findElement(subtotal).getAttribute("value");
	}
	
	public void clicarBtnContinue() {
		clicarBotao(btnContinue);
	}

}
