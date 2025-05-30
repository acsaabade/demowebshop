package tricentis.demowebshop.metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.opentest4j.AssertionFailedError;

import tricentis.demowebshop.drivers.Drivers;

public class Metodos extends Drivers {

	public void clicar(By locator) {
		try {
			esperarElementoClicavel(locator, 5);
			driver.findElement(locator).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}
	}

	public void clicar(String elemento, String texto) {
		try {
			driver.findElement(By.xpath("//*[" + elemento + "]//*[contains(text(),'" + texto + "')]")).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado com o texto " + texto);
		}

	}

	public void escrever(By locator, String texto) {
		try {
			esperarElementoClicavel(locator, 5);
			driver.findElement(locator).sendKeys(texto);
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}
	}

	public void validarTexto(By locator, String textoDesejado) {
		try {
			String textoCapturado = driver.findElement(locator).getText();
			assertEquals(textoDesejado, textoCapturado);
		} catch (Exception e) {
			throw new AssertionFailedError("Texto em branco ou errado!");
		}
	}

	public void validarTexto(String textoDesejado) {
		try {
			esperarElementoVisivel(By.xpath("//*[contains(text(),'" + textoDesejado + "')]"), 10);
			String textoCapturado = driver.findElement(By.xpath("//*[contains(text(),'" + textoDesejado + "')]"))
					.getText();
			assertTrue(textoCapturado.contains(textoDesejado),
					"Esperado conter: '" + textoDesejado + "' mas foi encontrado: '" + textoCapturado + "'");
		} catch (Exception e) {
			throw new AssertionFailedError("Texto '" + textoDesejado + "' não encontrado ou visível.");
		}
	}

	public void esperarElementoClicavel(By locator, int segundos) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}
	}

	public void esperarElementoVisivel(By locator, int segundos) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}
	}

	public void validarUrl(String urlDesejada) {
		try {
			assertEquals(urlDesejada, driver.getCurrentUrl());
		} catch (Exception e) {
			throw new NotFoundException(urlDesejada + " não encontrada.");
		}
	}

	public String alrt() {

		return driver.switchTo().alert().getText();

	}

	public boolean existText(By elemento, String textoEsperado) {
		List<WebElement> elementos = driver.findElements(elemento);

		if (elementos.isEmpty()) {
			return false;
		}

		String textoNatela = elementos.get(0).getText().trim();
		return textoNatela.equalsIgnoreCase(textoEsperado);
	}

}
