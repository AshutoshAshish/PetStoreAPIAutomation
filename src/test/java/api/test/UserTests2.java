package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userData;
	
	@BeforeClass
	public void setup() {
		
		faker= new Faker();
		userData= new User();
		
		userData.setId(faker.idNumber().hashCode());
		userData.setUsername(faker.name().username());
		userData.setFirstName(faker.name().firstName());
		userData.setLastName(faker.name().lastName());
		userData.setEmail(faker.internet().safeEmailAddress());
		userData.setPassword(faker.internet().password(5,10));
		userData.setPhone(faker.phoneNumber().cellPhone());
	}
	
	//@Test(priority=1)
	public void testPostUser() {
		
		Response res = UserEndPoints2.createUser(userData);
		res.then().log().all();
		res.then().statusCode(200);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	//@Test(priority=2)
	public void testGetUser() {
		
		Response res = UserEndPoints2.getUser(userData.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	//@Test(priority=3)
	public void testUpdateUser() {
		
		userData.setFirstName(faker.name().firstName());
		userData.setLastName(faker.name().lastName());
		userData.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndPoints2.updateUser(userData.getUsername(), userData);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	//@Test(priority=4)
	public void testDeleteUser() {
		Response res = UserEndPoints2.deleteUser(userData.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	@Test(priority=5)
	public void testLoginUser() {
		Response  res= UserEndPoints2.getUserLogin(userData.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	@Test(priority=6)
	public void testLogoutUser() {
		Response res = UserEndPoints2.getUserLogout();
		//res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}
	
}
