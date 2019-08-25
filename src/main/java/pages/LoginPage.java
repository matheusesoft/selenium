package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	private By username = By.name("userName");
	private By password = By.name("password");
	private By btnSignIn = By.name("login");
	
	public void inserirUserName(String arg) {
		escrever(username, arg);
	}
	
	public void inserirPassword(String arg) {
		escrever(password, arg);
	}
	
	public void clicarBtnSignIn() {
		clicarBotao(btnSignIn);
	}
	
	public boolean verificarPage(String url) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignIn));
		} catch (TimeoutException e) {
			return false;
		}
		if(url.charAt(url.length()-1) != '/') {
			url += "/";
		}
		return url.equals(getCurrentUrl());
	}

}
