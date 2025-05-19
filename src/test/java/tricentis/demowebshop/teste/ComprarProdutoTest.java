package tricentis.demowebshop.teste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.pages.HomePage;

public class ComprarProdutoTest {
	
	HomePage home = new HomePage();
	
	@BeforeEach
	public void setup() {
		Navegadores.abrirNavegador();
		home.login("tojexov347@benznoi.com", "030798AA");

	}
	
	@Test
	public void comprarProduto() {
		
	}

}
