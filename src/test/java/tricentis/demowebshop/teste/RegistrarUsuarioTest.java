package tricentis.demowebshop.teste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;
import tricentis.demowebshop.utils.MassaTestes;

public class RegistrarUsuarioTest {

	Elementos el = new Elementos();
	Metodos metodo = new Metodos();
	MassaTestes massa = new MassaTestes();

	@BeforeEach
	public void setup() {
		Navegadores.abrirNavegador();
		metodo.clicar(el.menuRegister);
	}

	@AfterEach
	public void tearDown() {
		Navegadores.fecharNavegador();
	}

	@Test
	public void registroSucesso() {
		String email = massa.retornarDados("emailGmail");
		metodo.escrever(el.firstName, "Acsa");
		metodo.escrever(el.lastName, "Abade");
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, "030798AA");
		metodo.escrever(el.ConfirmPassword, "030798AA");
		metodo.clicar(el.btnRegister);
		metodo.validarTexto(email);
	}

	@Test
	public void registraEmailRegistrado() {
		metodo.escrever(el.firstName, "Acsa");
		metodo.escrever(el.lastName, "Abade");
		metodo.escrever(el.Email, "tojexov347@benznoi.com");
		metodo.escrever(el.Password, "030798AA");
		metodo.escrever(el.ConfirmPassword, "030798AA");
		metodo.clicar(el.btnRegister);
		metodo.validarTexto("The specified email already exists");
	}

	@Test
	public void registraEmailForaPadrao() {
		metodo.escrever(el.firstName, "Acsa");
		metodo.escrever(el.lastName, "Abade");
		metodo.escrever(el.Email, "@");
		metodo.escrever(el.Password, "030798AA");
		metodo.escrever(el.ConfirmPassword, "030798AA");
		metodo.clicar(el.btnRegister);
		metodo.validarTexto("Wrong email");
	}

	@Test
	public void registrarConfirmacaoDeSenhaDiferentes() {
		metodo.escrever(el.firstName, "Acsa");
		metodo.escrever(el.lastName, "Abade");
		metodo.escrever(el.Email, "kopak44702@bauscn.com");
		metodo.escrever(el.Password, "030798AA");
		metodo.escrever(el.ConfirmPassword, "030798A8");
		metodo.clicar(el.btnRegister);
		metodo.validarTexto("The password and confirmation password do not match.");
	}

	@Test
	public void registrarSenhaForaDoPadrao() {
		metodo.escrever(el.firstName, "Acsa");
		metodo.escrever(el.lastName, "Abade");
		metodo.escrever(el.Email, "kopak44702@bauscn.com");
		metodo.escrever(el.Password, "a");
		metodo.escrever(el.ConfirmPassword, "a");
		metodo.clicar(el.btnRegister);
		metodo.validarTexto("The password should have at least 6 characters.");
	}

	@Test
	public void registrarComDadosEmBranco() {
		metodo.clicar(el.btnRegister);
		metodo.validarTexto("First name is required.");
		metodo.validarTexto("Last name is required.");
		metodo.validarTexto("Email is required.");
		metodo.validarTexto("Password is required.");
		metodo.validarTexto("Password is required.");
	}

}

