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

}
