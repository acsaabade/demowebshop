package tricentis.demowebshop.config;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import tricentis.demowebshop.drivers.Drivers;

public class Navegadores extends Drivers {

	public static void abrirNavegador() {
		try {
			ChromeOptions option = new ChromeOptions();
			// option.addArguments("--headless"); // não abre o navegador
			driver = new ChromeDriver();
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.err.println("Erro ao abrir Navegador " + e.getCause());
			throw new WebDriverException();

		}

	}

	public static void fecharNavegador() {
		driver.quit();
	}

}
