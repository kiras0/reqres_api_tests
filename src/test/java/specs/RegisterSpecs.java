package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class RegisterSpecs {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().uri();

    public static ResponseSpecification registerResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public static ResponseSpecification singleUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();
    public static ResponseSpecification resourceListResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)

            .build();
    public static ResponseSpecification failedRegisterResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(ALL)
            .build();
    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(ALL)
            .build();
    public static ResponseSpecification error404Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(STATUS)
            .build();

}
