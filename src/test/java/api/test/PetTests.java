package api.test;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payloads.Pet;
import api.payloads.PetCategory;
import api.payloads.PetTags;
import io.restassured.response.Response;

public class PetTests {
	
	Faker faker;
	Pet petData;
	String[] statuses= {"available","pending","sold"};
	String status;
	int petId;
	
	
	
	@BeforeTest
	public void setUp() throws FileNotFoundException {
		
		faker = new Faker();
		petData= new Pet();
		
		petData.setId(faker.idNumber().hashCode());
		PetCategory category= new PetCategory();
		category.setCategoryID(faker.idNumber().hashCode());
		category.setCategoryName(faker.name().lastName());
		petData.setCategory(category);
		petData.setName(faker.animal().name());
		petData.setPhotoUrls(Arrays.asList(faker.internet().url()));
		PetTags tag= new PetTags();
		tag.setTagID(faker.idNumber().hashCode());
		tag.setTagName(faker.name().bloodGroup());
		petData.setTags(Arrays.asList(tag));
		petData.setStatus(faker.options().option(statuses));
				
		
	}
	
	@Test(priority=1)
	public void testPetPost() {
		
		Response res= PetEndPoints.testCreatePet(petData);
		res.then().log().all();
		
		petId=Integer.parseInt(res.jsonPath().get("id").toString());
		System.out.println("Pet Id is: "+petId);
		
		status = res.jsonPath().get("status").toString();
		
		System.out.println("Pet Status is: "+status);
		
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	@Test(priority=2)
	public void testPetPost2() throws FileNotFoundException {
		
		Response res= PetEndPoints.testCreatePetusingJSONFile();
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	@Test(priority=3)
	public void testPetPut() {
		
		petData.setName(faker.animal().name());
		
		Response res=PetEndPoints.testUpdatePet(petData);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void testFindPetByStatus() {
		
		Response res= PetEndPoints.testGetPetByStatus(status);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
	}
}