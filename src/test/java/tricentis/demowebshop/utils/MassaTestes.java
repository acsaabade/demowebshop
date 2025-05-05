package tricentis.demowebshop.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MassaTestes {

	public String retornarDados(String dado) {

		Response response = RestAssured.get("https://plataforma.dev.e2etreinamentos.com.br/api/massa-teste/gerar");

		return response.jsonPath().getString(dado);
	}

}
