package tricentis.demowebshop.teste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;
import tricentis.demowebshop.utils.MassaTestes;

public class LoginTest {

	Metodos metodo = new Metodos();
	Elementos el = new Elementos();

	@BeforeEach
	public void setup() {
		Navegadores.abrirNavegador();
		metodo.clicar(el.menuLogin);
	}

	@AfterEach
	public void tearDown() {
		Navegadores.fecharNavegador();
	}

	@Test
	public void loginSucesso() {
		String email = "tojexov347@benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, "030798AA");
		metodo.clicar(el.btnLogin);
		metodo.validarTexto(email);

	}

	@Test
	public void senhaInvalida() {
		String email = "tojexov347@benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, "errado");
		metodo.clicar(el.btnLogin);
		metodo.validarTexto("Login was unsuccessful. Please correct the errors and try again");
		metodo.validarTexto("The credentials provided are incorrect");
		
	}

	@Test
	public void emailForaDoPadrao() {
		String email = "tojexov347benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, "030798AA");
		metodo.clicar(el.btnLogin);
		metodo.validarTexto("Please enter a valid email address.");
		
	}

	@Test
	public void emailInexistente() {
		String email = "1";
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, "030798AA");
		metodo.clicar(el.btnLogin);
		metodo.validarTexto("Please enter a valid email address.");
		
		
	}

	@Test
	public void senhaBranco() {
		String email = "tojexov347@benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.clicar(el.btnLogin);
		metodo.validarTexto("Login was unsuccessful. Please correct the errors and try again");
		metodo.validarTexto("The credentials provided are incorrect");

	}

	@Test
	public void emailBranco() {
		metodo.escrever(el.Password, "030798AA");
		metodo.clicar(el.btnLogin);
		metodo.validarTexto("Login was unsuccessful. Please correct the errors and try again");
		metodo.validarTexto("No customer account found");
		

	}
}
