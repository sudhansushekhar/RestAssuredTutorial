package session1;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class RestAssuredWithStaticImport {
	
	@Test
	public void test01() {
		Response resp = get("https://reqres.in/api/users?page=2");
		
		//print response code, response body, response header and response time
		
		System.out.println("Response Code : " + resp.getStatusCode());
		System.out.println("Response Body : " + resp.getBody().asString());
		System.out.println("Response Header content type : " + resp.header("Content-Type"));
		System.out.println("Response Headers : " + resp.headers());
		System.out.println("Response Time : " + resp.time());
		
		
		//validate status code as 200
		int expectedStatusCode = resp.getStatusCode();
		int actualStatusCode = 200;
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
	
	//writing in BDD style 
	@Test
	public void testBDD() {
		//using given, when then
		baseURI ="https://reqres.in/api/users/";
		
		given()
			.queryParam("page", "2")
		.when()
			.get()
		.then()
			.statusCode(200);
	}
}
