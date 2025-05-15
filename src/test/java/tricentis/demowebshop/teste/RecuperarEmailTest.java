package tricentis.demowebshop.teste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;

public class RecuperarEmailTest {

	Elementos el = new Elementos();
	Metodos metodo = new Metodos();

	@BeforeEach
	public void setup() {
		Navegadores.abrirNavegador();
		metodo.clicar(el.menuLogin);
		metodo.clicar(el.menuRecuperarEmail);
	}

	@AfterEach
	public void tearDown() {
		Navegadores.fecharNavegador();
	}

	@Test
	public void recuperarEmailSucesso() {
		String email = "tojexov347@benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.clicar(el.btnRecuperar);
		metodo.validarTexto("Email with instructions has been sent to you.");

	}

	@Test
	public void recuperarEmailForaPadrao() {
		String email = "tojexov347benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.clicar(el.btnRecuperar);
		metodo.validarTexto("Wrong email");

	}

	@Test
	public void recuperarEmailBranco() {
		metodo.clicar(el.btnRecuperar);
		metodo.validarTexto("Enter your email");

	}

}