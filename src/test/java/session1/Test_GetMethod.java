package session1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GetMethod {
//https://reqres.in/api/users?page=2
	
	@Test
	public void test01() {
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		
		//print response code, response body, response header and response time
		
		System.out.println("Response Code : " + resp.getStatusCode());
		System.out.println("Response Body : " + resp.getBody().asString());
		System.out.println("Response Header content type : " + resp.header("Content-Type"));
		System.out.println("Response Headers : " + resp.headers());
		System.out.println("Response Time : " + resp.time());
	}
}
