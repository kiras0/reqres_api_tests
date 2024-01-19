import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@DisplayName("API Test on Regres")
@Tag("api")
public class ApiTest extends TestBase {

    @Test
    @DisplayName("GET a correct request for single user")
    void newApiTest() {
        given()
                .log().uri()
                .get("/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.first_name", is("Janet"));

    }
}
