package apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.List;

import model.Category;
import model.Pet;
import model.Tag;
import utils.ConfigReader;

/**
 * @author Suma Kondapaneni
 * @created 01 Jul 2025
 */

public class APITests {
	

    private static final long PET_ID = 1001;// to be modified


    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.get("api.baseUrl");
    }
 

    // ----- PET TESTS -----
    @Test(priority = 1)
    public void createPetUsingPojo() {
    	 // Create category
        Category category = new Category();
        category.setId(10);
        category.setName("Cats");

        // Create tag
        Tag tag = new Tag();
        tag.setId(201);
        tag.setName("fluffy");

        // Create pet
        Pet pet = new Pet();
        pet.setId(PET_ID);
        pet.setName("FluffyCat");
        pet.setStatus("available");
        pet.setCategory(category);
        pet.setPhotoUrls(List.of("http://example.com/cat.jpg"));
        pet.setTags(List.of(tag));

        // Send POST request
        Response response = given()
        	.log().all()  // Log the full request
            .contentType("application/json")
            .body(pet)
        .when()
            .post("/pet")
        .then()
        .log().all()  // Log the full response
            .statusCode(200)
            .extract().response();
        
        

        // Validate with JsonPath
        JsonPath jp = response.jsonPath();
        assertEquals(jp.getLong("id"), PET_ID);
        assertEquals(jp.getString("name"), "FluffyCat");
        assertEquals(jp.getString("status"), "available");
        assertEquals(jp.getString("category.name"), "Cats");
        assertEquals(jp.getString("tags[0].name"), "fluffy");
    }

    @Test(priority = 2)
    public void getPetAndValidateWithJsonPath() {
        Response response = given()
            .when()
            .get("/pet/" + PET_ID)
            .then()
            .statusCode(200)
            .extract().response();

        JsonPath jp = response.jsonPath();
        assertEquals(jp.getLong("id"), PET_ID);
        assertEquals(jp.getString("name"), "FluffyCat");
        assertEquals(jp.getString("status"), "available");
    }

    @Test(priority = 3)
    public void updatePetUsingPojo() {
        // Reuse category and tag objects
        Category category = new Category();
        category.setId(10);
        category.setName("Cats");

        Tag tag = new Tag();
        tag.setId(201);
        tag.setName("fluffy");

        // Updated pet details
        Pet pet = new Pet();
        pet.setId(PET_ID);
        pet.setName("FluffyCatUpdated");
        pet.setStatus("sold");
        pet.setCategory(category);
        pet.setPhotoUrls(List.of("http://example.com/cat-updated.jpg"));
        pet.setTags(List.of(tag));

        Response response = given()
            .contentType("application/json")
            .body(pet)
        .when()
            .put("/pet")
        .then()
            .statusCode(200)
            .extract().response();

        JsonPath jp = response.jsonPath();
        assertEquals(jp.getString("name"), "FluffyCatUpdated");
        assertEquals(jp.getString("status"), "sold");
    }

    @Test(priority = 4)
    public void deletePetById() {
        Response response = given()
            .when()
            .delete("/pet/" + PET_ID)
            .then()
            .statusCode(200)
            .extract().response();

        JsonPath jp = response.jsonPath();
        assertEquals(jp.getString("message"), String.valueOf(PET_ID));
    }
    
    @Test(priority = 5)
    public void deletePetByIdNotExists() {
    	
    	long PetIdNotExists= 98989;
        Response response = given()
            .when()
            .delete("/pet/" + PetIdNotExists)
            .then()
            .statusCode(404)  //Pet Not Found returns
            .extract().response();

        JsonPath jp = response.jsonPath();
        assertEquals(jp.getString("message"), String.valueOf(PET_ID));
    }
}


