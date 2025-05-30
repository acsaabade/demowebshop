package tricentis.demowebshop.teste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.pages.HomePage;

public class LoginTest {

	HomePage home = new HomePage();

	@BeforeEach
	public void setup() {
		Navegadores.abrirNavegador();

	}

	@AfterEach
	public void tearDown() {
		Navegadores.fecharNavegador();
	}

	@Test
	public void loginSucesso() {
		home.login("tojexov347@benznoi.com", "030798AA");

	}

	@Test
	public void senhaInvalida() {
		home.login("tojexov347@benznoi.com", "erro", "The credentials provided are incorrect");

	}

	@Test
	public void emailForaDoPadrao() {
		home.login("tojexov347benznoi.com", "030798AA", "Please enter a valid email address.");

	}

	@Test
	public void emailInexistente() {
		home.login("1", "030798AA", "Please enter a valid email address.");

	}

	@Test
	public void senhaBranco() {
		home.login("tojexov347@benznoi.com", "", "The credentials provided are incorrect");

	}

	@Test
	public void emailBranco() {
		home.login("", "030798AA", "No customer account found");

	}
}
