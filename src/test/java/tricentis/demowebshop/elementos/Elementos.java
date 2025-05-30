package tricentis.demowebshop.elementos;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class Elementos {

	/*
	 * Elementos para registrar usuário
	 */

	public By menuRegister = By.xpath("//a[@href='/register']");
	public By firstName = By.id("FirstName");
	public By lastName = By.id("LastName");
	public By Email = By.id("Email");
	public By Password = By.id("Password");
	public By ConfirmPassword = By.id("ConfirmPassword");
	public By btnRegister = By.id("register-button");

	/*
	 * Elementos para registrar Login
	 */

	public By menuLogin = By.xpath("//a[@href='/login']");
	public By btnLogin = By.xpath("//input[@class='button-1 login-button']");

	/*
	 * Elementos para recuperar email
	 */

	public By menuRecuperarEmail = By.xpath("//a[@href='/passwordrecovery']");
	public By btnRecuperar = By.xpath("//input[@class='button-1 password-recovery-button']");

	/*
	 * Elemento para registrar Logout
	 */

	public By menuLogout = By.xpath("//a[@href='/logout']");

	/*
	 * Elementos para limpar o Carrinho
	 */

	public By menuCarrinho = By.id("topcartlink");
	public By checkBoxRemoverProduto = By.name("removefromcart");
	public By atualizarCarrinho = By.name("updatecart");
	public By carrinhoVazio = By.xpath("//div[normalize-space(text())='Your Shopping Cart is empty!']");

}
