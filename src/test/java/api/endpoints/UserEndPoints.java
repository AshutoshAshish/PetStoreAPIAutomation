package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import api.payloads.User;

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		
			.when()
				.post(Routes.post_url);
		
		return res;
	}
	
	public static Response getUser(String userName) {
		
		Response res= given()
					.pathParam("username", userName)
				.when()
					.get(Routes.get_url);
		return res;
	}
	
	public static Response updateUser(String userName, User payload) {
		
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
		
			.when()
				.put(Routes.put_url);
		
		return res;
	}
	
	public static Response deleteUser(String userName) {
		
		Response res= given()
				.pathParam("username", userName)
			.when()
				.get(Routes.delete_url);
		return res;
	}
	//
	public static Response getUserLogin(String userName) {
		
		Response res = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("username", userName)
				.when()
					.get(Routes.get_login_url);
		
		return res;
	}
	
	public static Response getUserLogout() {
		
		Response res = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
				.when()
					.get(Routes.get_logout_url);
		
		return res;
				
	}

}
