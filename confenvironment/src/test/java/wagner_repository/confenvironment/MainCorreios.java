package wagner_repository.confenvironment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainCorreios {
	
	WebDriver driver;
	Select selectUf;
	@Before
	public void setupThePage() {
		System.setProperty("webdriver.chrome.driver",
		        "C:\\Users\\Wagner\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test
	public void preencheUF() {
		// ESCOLHE VALOR UF
				selectUf = new Select(driver.findElement(By.name("UF")));
				
				assertNotNull(selectUf);
				selectUf.selectByVisibleText("RS");
				
				
		
	}
	
	@Test
	public void preencheFormCorreiosBuscaLogradouroPorBairro() {
					
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");
		
	
		
		WebElement localidade = driver.findElement(By.name("Localidade"));
		localidade.sendKeys("Porto Alegre");
		
		WebElement bairro = driver.findElement(By.name("Bairro"));
		bairro.sendKeys("Alto Petrópolis");
		
		
		WebElement buscarButton = driver.findElement(By.cssSelector("input[type='submit'"));
		buscarButton.click();
	}



	@After
	public void closePage() {
		driver.quit();
		
	}
}
