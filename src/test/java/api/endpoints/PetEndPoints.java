package api.endpoints;

import static io.restassured.RestAssured.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import api.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response testCreatePet(Pet petPayload) {
		
		Response res= given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(petPayload)
				.when()
					.post(Routes.pet_post_url);
					
		return res;			
	}
	
	public static Response testCreatePetusingJSONFile() throws FileNotFoundException {
		
		//File f = new File(".\\testData\\petData.json");
		FileReader fr = new FileReader(".\\testData\\petData.json");
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		Response res= given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(data.toString())
				.when()
					.post(Routes.pet_post_url);
					
		return res;			
	}
	
	public static Response testUpdatePet(Pet payload) {
		
		Response res= given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.put(Routes.pet_put_url);
		return res;
	}
	
	public static Response testGetPetByStatus(String status) {
		
		Response res = given()
					.baseUri(Routes.base_url)
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("status", status)
				.when()
					.get(Routes.petByStatus_get_url);
		return res;
	}

}
