package session2;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class checkForValidResponse {
//https://reqres.in/api/users

	@Test
	public void getSingleUSer() {
		baseURI = "https://reqres.in/api/users";

		RequestSpecification reqSpec = given();
		// call get method
		Response resp = reqSpec.get();

		// gets response code
		int respCode = resp.getStatusCode();
		System.out.println("Response code returned :" + respCode);
		int expCode = 200;

		// validate actual and expected
		Assert.assertEquals(respCode, expCode);

		String statusLine = resp.getStatusLine();
		System.out.println("Status line contains :" + statusLine);

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status line received");

	}

	@Test
	public void getSingleUSerUsingValidatableResponse() {
		baseURI = "https://reqres.in/api/users";

		RequestSpecification reqSpec = given();
		// call get method
		Response resp = reqSpec.get();

		ValidatableResponse valResp = resp.then();
		valResp.statusCode(200);
		System.out.println("First validation successfull. Second validation starts from here.");
		valResp.statusLine("HTTP/1.1 200 OK");
	}

	@Test
	public void getSingleUSerBDD_style() {

		given()
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}
}
