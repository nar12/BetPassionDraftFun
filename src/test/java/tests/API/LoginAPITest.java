package tests.API;

import API.RequestLogin;
import API.ResponseSuccessLoginResult;
import API.Specifications;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.UI.BaseTest.PASSWORD;
import static tests.UI.BaseTest.USERNAME;

public class LoginAPITest {
    public static final String URL = "https://stagingapi.pokerplaza.com/api_v2";

    @Test
    public void checkSuccessLogin() {
        /*Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());
        RequestLogin requestLogin = new RequestLogin(USERNAME,PASSWORD,"569450","569450");
        ResponseSuccessLoginResult responseSuccessLoginResult = given().
                body(requestLogin).
                when().
                post("/authenticatePlayer").
                then().extract().body().jsonPath().getObject("result",ResponseSuccessLoginResult.class);
        Assert.assertEquals(USERNAME,responseSuccessLoginResult.getUsername());*/

        given().
                contentType(ContentType.JSON).
                body(new File("src/main/java/jsons/login.json")).
                when().
                post("https://stagingapi.pokerplaza.com/api_v2/authenticatePlayer").
                then().log().all().
                assertThat().
                statusCode(200).
                body("result.username", equalTo(USERNAME)).
                body("result.countryCode", equalTo("ARM"));
    }

    @Test
    public void accessToken() {
        String token = given().
                contentType(ContentType.JSON).
                body(new File("src/main/java/jsons/login.json")).
                when().
                post("https://stagingapi.pokerplaza.com/api_v2/authenticatePlayer").
                then().log().all().
                extract().body().jsonPath().getString("result.token");
        System.out.println(token);
        given().
                contentType(ContentType.JSON).
                header("x-access-token", token).
                when().
                get("https://stagingapi.pokerplaza.com/api/account/574679/balance").
                then().log().all();
    }
}
