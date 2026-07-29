package com.example.api.services;

import com.example.api.models.UserRequest;
import com.example.api.models.UserResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApiService {

    private static final String USERS_ENDPOINT = "/api/users";

    @Step("Send POST request to create a new user")
    public Response createUserRaw(UserRequest userRequest) {
        return given()
                .body(userRequest)
                .when()
                .post(USERS_ENDPOINT);
    }

    @Step("Create user and parse response to UserResponse POJO")
    public UserResponse createUser(UserRequest userRequest) {
        return createUserRaw(userRequest)
                .then()
                .statusCode(201)
                .extract()
                .as(UserResponse.class);
    }

    @Step("Send GET request to fetch user by ID")
    public Response getUserById(String userId) {
        return given()
                .pathParam("id", userId)
                .when()
                .get(USERS_ENDPOINT + "/{id}");
    }
}
