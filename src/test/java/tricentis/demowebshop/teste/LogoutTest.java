package tricentis.demowebshop.teste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;

public class LogoutTest {

	Elementos el = new Elementos();
	Metodos metodo = new Metodos();

	@BeforeEach
	public void setup() {
		Navegadores.abrirNavegador();
		metodo.clicar(el.menuLogin);
		String email = "tojexov347@benznoi.com";
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, "030798AA");
		metodo.clicar(el.btnLogin);

	}

	@AfterEach
	public void tearDown() {
		Navegadores.fecharNavegador();

	}

	@Test
	public void logoutSucesso() {
		metodo.esperarElementoClicavel(el.menuLogout, 10);
		metodo.clicar(el.menuLogout);
		metodo.validarUrl("https://demowebshop.tricentis.com/");

	}

}
