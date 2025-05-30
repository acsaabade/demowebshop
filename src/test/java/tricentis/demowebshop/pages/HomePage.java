package tricentis.demowebshop.pages;

import org.openqa.selenium.By;

import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;

public class HomePage {

	Metodos metodo = new Metodos();
	Elementos el = new Elementos();

	public void enviarDadosDeLogin(String email, String senha) {
		metodo.clicar(el.menuLogin);
		metodo.escrever(el.Email, email);
		metodo.escrever(el.Password, senha);
		metodo.clicar(el.btnLogin);

	}

	public void login(String email, String senha) {
		enviarDadosDeLogin(email, senha);
		metodo.validarTexto(email);
	}

	public void login(String email, String senha, String msgError) {
		enviarDadosDeLogin(email, senha);
		metodo.validarTexto(msgError);
	}

	public void login(String email, String senha, String msgError, String msgError1) {
		enviarDadosDeLogin(email, senha);
		metodo.validarTexto(msgError);
		metodo.validarTexto(msgError1);

	}

	/**
	 * Se não possuir subcategoria informar no segundo parametro null
	 * 
	 * @param categoria
	 * @param subCategoria
	 */

	public void headerMenu(String categoria) {
		metodo.clicar("@class='top-menu'", categoria);
	}

	public void addCarrinho(String subMenu, String posicao) {
		By menu = By.xpath("//div[@class='sub-category-item']//a[contains(text(),'" + subMenu + "')]");
		By produto = By.xpath("//div[@class='product-grid']//div[@class='item-box'][" + posicao + "]");
		metodo.clicar(menu);
		metodo.clicar(produto);
		metodo.clicar(By.xpath("//input[@id='add-to-cart-button-72']"));
	}

	public void validarCarrinho() {
		metodo.clicar("span", "Shopping cart");
		metodo.clicar(By.xpath("//*[@id='termsofservice']"));
		metodo.clicar(By.xpath("//*[@id='checkout']"));
		metodo.clicar(By.xpath("//*[@onclick='Billing.save()']"));
		metodo.clicar(By.xpath("//*[@onclick='Shipping.save()']"));
		metodo.clicar(By.xpath("//*[@onclick='ShippingMethod.save()']"));
		metodo.clicar(By.xpath("//*[@onclick='PaymentMethod.save()']"));
		metodo.clicar(By.xpath("//*[@onclick='PaymentInfo.save()']"));
		metodo.clicar(By.xpath("//*[@onclick='ConfirmOrder.save()']"));
	}

	public void validarCarrinhoDeslogado() {
		metodo.clicar("span", "Shopping cart");
		metodo.clicar(By.xpath("//*[@id='termsofservice']"));
		metodo.clicar(By.xpath("//*[@id='checkout']"));
		metodo.validarUrl("https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart");

	}

	public void limparCarrinho() {
		metodo.clicar(el.menuCarrinho);
		if (!metodo.existText(el.carrinhoVazio, "Your Shopping Cart is empty!")) {
			metodo.clicar(el.checkBoxRemoverProduto);
			metodo.clicar(el.atualizarCarrinho);
		}
		
		
	}

}