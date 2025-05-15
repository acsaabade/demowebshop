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

	}

	@AfterEach
	public void tearDown() {
		Navegadores.fecharNavegador();
	}

	@Test
	public void logoutSucesso() {

	}

}
