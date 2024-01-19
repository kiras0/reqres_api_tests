import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

@DisplayName("API Test on Regres")
@Tag("api")
public class ApiTest extends TestBase {

    @Test
    @DisplayName("GET a correct request for single user")
    void newApiTest() {
        given()
                .log().uri()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.first_name", is("Janet"));

    }

    @Test
    @DisplayName("Test for data from resource list")
    public void listOfResourcesTest() {

        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("/unknown")
                .then()
                .log().status()
                .log().body()
                .body("total",is(12))
                .body("data.id[1]", equalTo(2))
                .body("data.name[1]", equalTo("fuchsia rose"))
                .assertThat().contentType(ContentType.JSON);
    }
    @Test
    @DisplayName("POST successful user registration")
    void successulRegistration() {
        String userRegister = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        given()
                .body(userRegister)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));

    }
    @Test
    @DisplayName("POST unsuccessful user registration")
    void unsuccessulRegistration() {
        String serRegister = "{\n" + "    \"email\": \"eve.holt@reqres.in\"\n" + "}";
                given()
                .body(serRegister)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
    @Test
    @DisplayName("Create new user request")
    void createUserRequest() {
        String serRegister = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .body(serRegister)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("createdAt", notNullValue());
    }


    @Test
    @DisplayName("404")
    void api404Test() {
        given()
                .log().uri()
                .get("/unknown/23")
                .then()
                .log().status()
                .statusCode(404);
    }
}
