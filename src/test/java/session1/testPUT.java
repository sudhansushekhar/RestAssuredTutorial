package session1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class testPUT {
		
	//PUT Method
	@Test
	public void updateUser() {
		//befor sending data we must create it using json
		JSONObject data = new JSONObject();
		data.put("name", "Singh");
		data.put("job", "tescher");
		
		baseURI = "https://reqres.in/api/users/975";
		
		given()
			.header("Content-type", "application/json")
			.contentType(ContentType.JSON)
			.body(data.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
}
