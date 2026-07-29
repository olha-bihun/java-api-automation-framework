package com.example.api.tests;

import com.example.api.models.UserRequest;
import com.example.api.models.UserResponse;
import com.example.api.services.UserApiService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Epic("User Management Service")
@Feature("User API")
public class UserApiTest extends BaseTest {

    private UserApiService userApiService;

    @BeforeClass
    public void initService() {
        userApiService = new UserApiService();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify successful user creation via POST /api/users")
    public void testCreateUserSuccess() {
        UserRequest request = new UserRequest("Olha Bihun", "Senior SDET");

        UserResponse response = userApiService.createUser(request);

        assertNotNull(response.getId(), "User ID should not be null");
        assertEquals(response.getName(), request.getName(), "Name mismatch");
        assertEquals(response.getJob(), request.getJob(), "Job mismatch");
        assertNotNull(response.getCreatedAt(), "Created timestamp missing");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify GET /api/users/{id} returns 200 OK for valid user")
    public void testGetUserSuccess() {
        Response response = userApiService.getUserById("2");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data.email"), "janet.weaver@reqres.in");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify GET /api/users/{id} returns 404 for non-existing user")
    public void testGetUserNotFound() {
        Response response = userApiService.getUserById("23");

        assertEquals(response.getStatusCode(), 404);
    }
}
