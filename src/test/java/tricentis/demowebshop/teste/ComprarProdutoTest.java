package tricentis.demowebshop.teste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tricentis.demowebshop.config.Navegadores;
import tricentis.demowebshop.pages.HomePage;

public class ComprarProdutoTest {

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
	public void comprarProduto() {
		home.login("tojexov347@benznoi.com", "030798AA");
		home.limparCarrinho();
		home.headerMenu("Computer");
		home.addCarrinho("Desk", "1");
		home.validarCarrinho();

	}

	@Test
	public void comprarProdutoDeslogado() {
		home.limparCarrinho();
		home.headerMenu("Computer");
		home.addCarrinho("Desk", "1");
		home.validarCarrinhoDeslogado();

	}
	
	public void validarCompraProduto() {
		home.login("tojexov347@benznoi.com", "030798AA");
		home.limparCarrinho();
		home.headerMenu("Computer");
		home.addCarrinho("Desk", "1");
		
		
	}

}
