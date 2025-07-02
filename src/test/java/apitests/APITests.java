package apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Category;
import model.Pet;
import model.Tag;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.List;

import utils.ConfigReader;

/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */

@Epic("Pet Store API")
@Feature("Pet Management")
public class APITests {
	


	@BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.get("api.baseUrl");
        
    }
    
  
    public void createPetUsingPojo() {
   	 
   }

    @Test(priority = 1)
    @Description("Create a new pet and retrieve it by ID to confirm it was saved correctly.")
    @Story("Create and Retrieve Pet")
    @Severity(SeverityLevel.CRITICAL)
    public void createAndGetPetTest() {
        long petId = System.currentTimeMillis();
     // Create category object
        Category category = new Category();
        category.setId(10);
        category.setName("Cats");

        // Create tag object
        Tag tag = new Tag();
        tag.setId(201);
        tag.setName("fluffy");

        // Create pet object
        Pet pet = new Pet();
        pet.setId(petId);
        pet.setName("FluffyCat");
        pet.setStatus("available");
        pet.setCategory(category);
        pet.setPhotoUrls(List.of("http://example.com/cat.jpg"));
        pet.setTags(List.of(tag));

        step("Create a new pet");
        Response createResponse = 
                given()
                //.log().all() //logs the request for debugging
                .contentType("application/json")
                .body(pet)
                .post("/pet");
        assertEquals(createResponse.statusCode(), 200, "Pet creation failed");

        step("Retrieve the newly created pet by ID");
        Response getResponse = 
                given()
               // .log().all()
                .get("/pet/" + petId);
        assertEquals(getResponse.statusCode(), 200, "Pet retrieval failed");

        // Validate with JsonPath
        JsonPath jp = getResponse.jsonPath();
        assertEquals(jp.getLong("id"), petId);
        assertEquals(jp.getString("name"), "FluffyCat");
        assertEquals(jp.getString("status"), "available");
        assertEquals(jp.getString("category.name"), "Cats");
        assertEquals(jp.getList("photoUrls").get(0),"http://example.com/cat.jpg");
        assertEquals(jp.getString("tags[0].name"), "fluffy");
    }

    @Test(priority = 2)
    @Description("Update the name of an existing pet and validate in the response.")
    @Story("Update Pet Name")
    @Severity(SeverityLevel.NORMAL)
    public void updatePetNameTest() {
        // Test logic to be implemented
    }

    @Test(priority = 3)
    @Description("Change the status of a pet from 'available' to 'sold' and validate in the response.")
    @Story("Update Pet Status")
    @Severity(SeverityLevel.NORMAL)
    public void updatePetStatusTest() {
        // Test logic to be implemented
    }

    @Test(priority = 4)
    @Description("Delete a pet and ensure it no longer exists in the store and validate in the response.")
    @Story("Delete Pet")
    @Severity(SeverityLevel.CRITICAL)
    public void deletePetTest() {
        // Test logic to be implemented
    }

    @Test(priority = 5)
    @Description("Try to retrieve a pet that does not exist and expect a 404 Not Found in the response.")
    @Story("Get Non-Existing Pet")
    @Severity(SeverityLevel.MINOR)
    public void getNonExistingPetTest() {
        // Test logic to be implemented
    }

    @Test(priority = 6)
    @Description("Attempt to create a pet with invalid data and verify the API responds with an error.")
    @Story("Negative Case: Invalid Pet Data")
    @Severity(SeverityLevel.CRITICAL)
    public void createPetWithInvalidDataTest() {
        // Test logic to be implemented
    }

    @Test(priority = 7)
    @Description("Create two pets with the same ID and observe how the API handles the duplicate.")
    @Story("Duplicate Pet ID Handling")
    @Severity(SeverityLevel.NORMAL)
    public void createDuplicatePetIdTest() {
        // Test logic to be implemented
    }

    @Test(priority = 8)
    @Description("Retrieve a list of pets based on their status (e.g., available, pending, sold).")
    @Story("Find Pets by Status")
    @Severity(SeverityLevel.NORMAL)
    public void getPetsByStatusTest() {
        // Test logic to be implemented
    }

    @Step("{0}")
    public void step(String message) {
        // Used for Allure @Step logging
    }


}


