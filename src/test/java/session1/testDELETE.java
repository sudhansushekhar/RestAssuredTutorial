package session1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testDELETE {
		
	//PUT Method
	@Test
	public void updateUser() {
	
		baseURI = "https://reqres.in/api/users/975";
		
		given()
		.when()
			.delete()
		.then()
			.statusCode(204)
			.log().all();
	}
}
