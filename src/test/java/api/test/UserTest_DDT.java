package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTest_DDT {
	
	SoftAssert sa= new SoftAssert();
	
	//@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userId, String uName, String fName, String lName, String uEmail, String pwd, String phNum) {
		
		User userData= new User();
		
		userData.setId(Integer.parseInt(userId));
		userData.setUsername(uName);
		userData.setFirstName(fName);
		userData.setLastName(lName);
		userData.setEmail(uEmail);
		userData.setPassword(pwd);
		userData.setPhone(phNum);
		
		Response resPostUser= UserEndPoints.createUser(userData);
		//resPostUser.then().log().all();
		
		sa.assertEquals(resPostUser.statusCode(), 200);
	}
	
	//@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName) {
		
		Response resDeleteUser= UserEndPoints.deleteUser(userName);
		sa.assertEquals(resDeleteUser.statusCode(), 200);
		
	}
	
	@Test(priority=3, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testLoginLogoutUser(String userName) {
		Response resLoginUser= UserEndPoints.getUserLogin(userName);
		resLoginUser.then().log().all();
		sa.assertEquals(resLoginUser.statusCode(), 200);
		
		Response res = UserEndPoints.getUserLogout();
		res.then().log().all();
		sa.assertEquals(res.statusCode(), 200);
		sa.assertAll();
	}
	
	//@Test(priority=4)
	public void testLogoutUser() {
		Response res = UserEndPoints.getUserLogout();
		res.then().log().all();
		sa.assertEquals(res.statusCode(), 200);
		sa.assertAll();
	}

}