package tests.API;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.UI.BaseTest.PASSWORD;
import static tests.UI.BaseTest.USERNAME;

public class LoginAPI {
    @Test
    public void checkSuccessLogin(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", USERNAME);
        requestParams.put("password", PASSWORD);
        requestParams.put("skinId", "569450");
        requestParams.put("parentId", "569450");

        given().
                contentType(ContentType.JSON).body(requestParams.toJSONString()).
                when().post("https://stagingapi.pokerplaza.com/api_v2/authenticatePlayer").
                then().
                assertThat().
                statusCode(200).
                body("result.username",equalTo(USERNAME)).
                body("result.countryCode",equalTo("ARM"));
    }
}
