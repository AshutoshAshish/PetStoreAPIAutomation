package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.testng.Assert;

import api.payloads.User;

public class UserEndPoints2 {
	/*
	public static Properties getURL() throws IOException {
		FileInputStream file = new FileInputStream("./src//test//resources//routes.properties");
		Properties prop= new Properties();
		prop.load(file);
		return prop;
	}*/
	
	public static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		//String post_url=getURL().getProperty("post_url");
		
		String post_url = getURL().getString("post_url");
		
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		
			.when()
				.post(post_url);
		
		return res;
	}
	
	public static Response getUser(String userName) {
		
		String get_url= getURL().getString("get_url");
		
		Response res= given()
					.pathParam("username", userName)
				.when()
					.get(get_url);
		return res;
	}
	
	public static Response updateUser(String userName, User payload) {
		
		String put_url= getURL().getString("put_url");
		
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
		
			.when()
				.put(put_url);
		
		return res;
	}
	
	public static Response deleteUser(String userName) {
		
		String delete_url= getURL().getString("delete_url");
		
		Response res= given()
				.pathParam("username", userName)
			.when()
				.get(delete_url);
		return res;
	}
	
	public static Response getUserLogin(String userName) {
		
		String get_login_url = getURL().getString("get_login_url");
		
		Response res = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("username", userName)
				.when()
					.get(get_login_url);
		
		return res;
	}
	
	public static Response getUserLogout() {
		
		String get_logout_url= getURL().getString("get_logout_url");
		
		Response res= given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
				.when()
					.get(get_logout_url);
		
		return res;
	}

}
