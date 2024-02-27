import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.TestData.*;
import static data.TestPath.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static specs.RegisterSpecs.*;

@Owner("Kiras0")
@Feature("Using reqres.in API testing GET and POST methods")
@DisplayName("API Test on Reqres")
@Tag("api")
public class ApiTest extends TestBase {

    @DisplayName("GET a correct request for single user")
    @Story("Testing of successful request for single user using method GET")
    @Test
    void newApiTest() {
        SingleUserResponseModel data =
                step("Requesting single user", () ->
                             given(requestSpec)
                                     .when()
                                    .get(users + "/2")
                                    .then()
                                    .spec(responseCode200)
                                    .extract().as(SingleUserResponseModel.class)
        );
        step("Check ID ", () ->
            assertEquals(2, data.getData().getId())
        );
    }

    @DisplayName("Test for data from resource list")
    @Story("Testing of successful request of user list using method GET")
    @Test
    public void listOfResourcesTest() {
        ListDataResponse list =
            step("Check ID ", () ->
                    given(requestSpec)
                .when()
                .get(unknown)
                .then()
                .spec(responseCode200)
                .extract().as(ListDataResponse.class)

       );
       step("Check number of users ", () ->
               assertThat(list.getTotal()).isEqualTo(userNum)

       );
        step("Check details of user No.2 ", () -> {
            assertEquals(id, list.getData()[1].getId());
            assertEquals(user2, list.getData()[1].getName());

        });
    }

    @DisplayName("POST successful user registration")
    @Story("Testing of successful registration using method GET")
    @Test
    void successfulRegistration() {
        RegisterBodyModel userRegister = new RegisterBodyModel();
        userRegister.setEmail(email);
        userRegister.setPassword(password);
        SuccessfulRegisterResponseModel response =
                step("Registration of new user", ()->
                        given(requestSpec)
                    .body(userRegister)
                    .when()
                    .post(register)
                    .then()
                    .spec(responseCode200)
                    .extract().as(SuccessfulRegisterResponseModel.class)
        );
        step("Check ID and Token", ()-> {
            assertEquals(token, response.getToken());
            assertEquals(4, response.getId());
        });
    }

    @DisplayName("POST unsuccessful user registration")
    @Story("Testing of unsuccessful registration with wrong credentials using method POST")
    @Test
    void unsuccessfulRegistration() {
        RegisterBodyModel userRegister = new RegisterBodyModel();
        userRegister.setEmail(email);
        UnsuccessfulRegisterResponseModel response =
        step("Posting only email no password", ()->
                given(requestSpec)
                    .body(userRegister)
                    .when()
                    .post(register)
                    .then()
                    .spec(responseCode400)
                   .extract().as(UnsuccessfulRegisterResponseModel.class)
        );
        step("Checking Error message", ()->
            assertEquals(error_mpass, response.getError())
        );
    }

    @DisplayName("Create new user request")
    @Story("Testing of successful creating new user info using method GET")
    @Test
    void createUserRequest() {
        NewUserBodyModel userParam = new NewUserBodyModel();
        userParam.setName(name);
        userParam.setJob(job);

        NewUserResponseModel response =
        step("Creating user with new params", ()->
             given(requestSpec)
                    .body(userParam)
                    .when()
                    .post(users)
                    .then()
                    .spec(responseCode201)
                    .extract().as(NewUserResponseModel.class)
        );
        step("Validating new user creation", ()-> {
            assertThat(response.getName()).isEqualTo(name);
            assertThat(response.getCreatedAt()).isNotNull();

        });
    }

    @Test
    @DisplayName("Testing for successful DELETE method for a user")
    void deleteUserTest() {
        step("Sending request to delete a user", () ->
                given(requestSpec)
                        .when()
                        .delete(users + "/2")
                        .then()
                        .spec(responseCode204));
    }

    @DisplayName("Testing unknown request for error 404")
    @Story("Testing of unsuccessful data request with wrong information using method GET")
    @Test
    void api404Test() {
        given()
                .get(unknown + "/23")
                .then()
                .spec(responseCode404);
    }
}