package com.qadev.automation.restClient;

import com.qadev.automation.util.ApiPath;
import com.qadev.automation.entity.Pet;
import com.qadev.automation.entity.User;
import groovy.transform.CompileStatic;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

@CompileStatic
public class PetStoreRestClient {

    private String apiKey;

    public  PetStoreRestClient(String apiBaseUri, String apiBasePath, String apiKey) {
        RestAssured.baseURI = apiBaseUri;
        RestAssured.basePath = apiBasePath;
        this.apiKey = apiKey;
    }

    public void createUser(User user)
    {
        given()
                .headers("api_key", this.apiKey)
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(ApiPath.USER_PATH)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public User getUser(String username)
    {
        return given()
                .headers("api_key", this.apiKey)
                .pathParam("username", username)
                .when()
                .get(ApiPath.USER_PATH+"/{username}")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(User.class);
    }

    public List<Pet> findByStatus(List<String> petStatus)
    {
        return given()
                .headers("api_key", this.apiKey)
                .queryParams("status",petStatus)
                .when()
                .get(ApiPath.PET_PATH+"/findByStatus")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().body().jsonPath().getList(".", Pet.class);
    }
}
