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

	}

	public void login(String email, String senha) {
		enviarDadosDeLogin(email, senha);
		metodo.validarTexto(email);
	}

	public void login(String email, String senha, String msgError) {
		enviarDadosDeLogin(email, senha);
		metodo.validarTexto(msgError);
	}
	
	public void headerMenu(String menu) {
		metodo.clicar("@class='top-menu'" , menu);
		
	}
}
