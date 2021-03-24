package io.cucumber.stephanie;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class rotinasSteps{
	
	public WebDriver browser;

	@Quando("eu entro no site do tornese um programador")
	public void eu_entro_no_site_do_tornese_um_programador() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	    
	  browser = new ChromeDriver();
	  browser.get("https://www.torneseumprogramador.com.br/");
	}

	@Quando("digito no campo de busca a palavra {string}")
	public void digito_no_campo_de_busca_a_palavra(String string) {
			WebElement input = browser.findElement( By.cssSelector("input[name='q']") );
			input.sendKeys(string);
	}

	@Quando("clico no botao enviar")
	public void clico_no_botao_enviar() {
		WebElement input = browser.findElement( By.cssSelector("button[class='btn btn-outline-dark btn-pesquisa']") );
		input.click();
	}

	@Entao("devo ver o resultado da busca")
	public void devo_ver_o_resultado_da_busca() {
		int input = browser.findElements( By.cssSelector(".div-card-aulas") ).size();
		assertTrue(input>0);
		browser.quit();
	}
}