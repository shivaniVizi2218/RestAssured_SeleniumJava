package APIs;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class RestAssuredApi {
  int id;
	@Test(priority=1)
	void getUser() throws JSONException, IOException {
		
		JSONObject data = new JSONObject(Files.readString(Paths.get(".//data.json")));
		String requestUrl=data.getString("getUserRequestUrl");
		given()
		.when()
		      .get(requestUrl)
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.body("total", equalTo(12))
		.body("data[0].id", equalTo(7))
		.log().all();
	}

	@Test(priority=2)
	void createUser() throws JSONException, IOException{
		JSONObject data = new JSONObject(Files.readString(Paths.get(".//data.json")));
	    String createUserPayload = data.getJSONObject("createUser").toString();
	    String requestUrl=data.getString("createUserPostRequestUrl");
		id=given()
		.contentType("application/json")
		.body(createUserPayload)
		.when()
		.post(requestUrl)
		.jsonPath().getInt("id");
		
	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	void updateUser() throws JSONException, IOException {
		JSONObject data = new JSONObject(Files.readString(Paths.get(".//data.json")));
	    String updateUserPayload = data.getJSONObject("updateUser").toString();
	    String requestUrl=data.getString("updateUserPutRequestUrl");
		given()
		.contentType("application/json")
		.body(updateUserPayload)
		.when()
		.put(requestUrl+id)
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=4)
	void deleteUser() throws JSONException, IOException {
		JSONObject data = new JSONObject(Files.readString(Paths.get(".//data.json")));
	    String requestUrl=data.getString("deleteUserDeleteRequestUrl");
		when()
		.delete(requestUrl+id)
		.then()
		.statusCode(204)
		.log().all();
	}
	
}
