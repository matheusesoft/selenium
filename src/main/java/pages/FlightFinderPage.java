package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.DriverFactory.getDriver;

public class FlightFinderPage extends BasePage {
	
	private By departingFrom = By.name("fromPort");
	private By arrivingIn = By.name("toPort");
	private By onMonth = By.name("fromMonth");
	private By onDay = By.name("fromDay");
	private By returningMonth = By.name("toMonth");
	private By returningDay = By.name("toDay");
	private By servClass = By.xpath("(//*[@name='servClass'])[1]");
	private By passengers = By.name("passCount");
	private By btnContinue = By.name("findFlights");
	private String month, day;
	
	public boolean verificarHome() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	public void selecionarDepartingFrom(String cidadeOrigem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.departingFrom));
		Select departingFrom = new Select(getDriver().findElement(this.departingFrom));
		departingFrom.selectByVisibleText(cidadeOrigem);
	}
	
	public void selecionarArrivingIn(String cidadeDestino) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.arrivingIn));
		Select arrivingIn = new Select(getDriver().findElement(this.arrivingIn));
		arrivingIn.selectByVisibleText(cidadeDestino);
	}
	
	public void selecionarOnMonth() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.onMonth));
		Select onMonth = new Select(getDriver().findElement(this.onMonth));
		month = "10";
		onMonth.selectByValue(month);
	}
	
	public void selecionarOnDay() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.onDay));
		Select onDay = new Select(getDriver().findElement(this.onDay));
		day = "20";
		onDay.selectByValue(day);
	}
	
	public void selecionarReturningMonth() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.returningMonth));
		Select returningMonth = new Select(getDriver().findElement(this.returningMonth));
		returningMonth.selectByValue(Integer.toString(Integer.parseInt(this.month)+1));
	}
	
	public void selecionarReturningDay() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.returningDay));
		Select returningDay = new Select(getDriver().findElement(this.returningDay));
		returningDay.selectByValue(Integer.toString(Integer.parseInt(this.day)+1));
	}
	
	public void selecionarClass() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.servClass));
		getDriver().findElement(this.servClass).click();
	}
	
	public void selecionarPassengers(String indicePassageiro) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(this.passengers));
		Select passengers = new Select(getDriver().findElement(this.passengers));
		passengers.selectByValue(indicePassageiro);
	}
	
	public void clicarBtnContinue() {
		clicarBotao(btnContinue);
	}

}
