package pages;

import static core.DriverFactory.getDriver;

import java.awt.SecondaryLoop;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	/********* TextField e TextArea ************/
	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	/********* Botao ************/
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	
	public void clicarBotaoPorTexto(String texto){
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}
	
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public boolean compareUrl(final String url) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		return wait.until(ExpectedConditions.urlContains(url));		
	}
}
