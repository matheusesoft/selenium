package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page extends BasePage {
	
	private By guide = By.cssSelector("a.mr-4[href='/guide']");
	private By albumsPhotos = By.cssSelector("a[href='/albums/1/photos']");
	
	public void clicarBtnGuide() {
		clicarBotao(guide);
	}

	public void clicarLinkAlbumsPhotos() {
		clicarBotao(albumsPhotos);
		System.out.println(getDriver().getPageSource());
	}

	public String getAlbuns() {
		return getDriver()
				.getPageSource()
				.replace("<html><head></head><body><pre style=\"word-wrap: break-word; white-space: pre-wrap;\">", "")
				.replace("</pre></body></html>", "");
	}
	
	public boolean verificarPage(String url) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(guide));
		} catch (TimeoutException e) {
			return false;
		}
		if(url.charAt(url.length()-1) != '/') {
			url += "/";
		}
		return url.equals(getCurrentUrl());
	}

}
