package session1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class testPOST {
	
	//POST Method
	@Test
	public void createUser() {
		//before sending data we must create it using json
		JSONObject data = new JSONObject();
		data.put("name", "Sudhanshu");
		data.put("job", "QA");
		
		baseURI = "https://reqres.in/api/users";
		
		given()
			.header("Content-type", "application/json")
			.contentType(ContentType.JSON)
			.body(data.toJSONString())
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all();
	}
	
}
