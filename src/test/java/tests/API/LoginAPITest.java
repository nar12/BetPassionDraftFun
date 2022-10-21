package tests.API;

import API.POJOs.RequestLogin;
import API.POJOs.correctLogin.ResponseSuccessLoginResult;
import API.POJOs.incorrectPasswordLogin.ResponseIncorrectPasswordLogin;
import API.POJOs.nonExistentUserLogin.ResponseNonExistentUserLogin;
import API.Specifications;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.UI.BaseTest.*;

public class LoginAPITest {
    public static final String URL = "https://stagingapi.pokerplaza.com/api_v2";

    @Test
    public void checkSuccessLogin() {
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());

        //With POJO
        RequestLogin requestLogin = new RequestLogin(USERNAME,PASSWORD,"569450","569450");
        ResponseSuccessLoginResult responseSuccessLoginResult = given().
                body(requestLogin).
                when().
                post("/authenticatePlayer").
                then().extract().body().jsonPath().getObject("result",ResponseSuccessLoginResult.class);

        Assert.assertEquals(USERNAME,responseSuccessLoginResult.getUsername());

        //Without POJO
        given().
                contentType(ContentType.JSON).
                body(new File("src/main/java/jsons/login.json")).
                when().
                post("/authenticatePlayer").
                then().log().all().
                assertThat().
                statusCode(200).
                body("result.username", equalTo(USERNAME)).
                body("result.countryCode", equalTo("ARM"));
    }
    @Test
    public void checkUnSuccessLoginWithWrongPassword(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecError400());

        //With POJO
        RequestLogin requestLogin = new RequestLogin(USERNAME,WRONG_PASSWORD,"569450","569450");
        ResponseIncorrectPasswordLogin response = given().
                body(requestLogin).
                when().
                post("/authenticatePlayer").
                then().log().all().extract().as(ResponseIncorrectPasswordLogin.class);

        Assert.assertEquals(response.getSuccess(),false);
        Assert.assertEquals(response.getMessage().getKey(),"incorrect_password");

        //Without POJO
        Map<String,String> userLogin = new HashMap<>();
        userLogin.put("username",USERNAME);
        userLogin.put("password",WRONG_PASSWORD);
        userLogin.put("skinId","569450");
        userLogin.put("parentId","569450");

        given().
                body(userLogin).
                when().
                post("/authenticatePlayer").
                then().log().all().
                assertThat().
                body("success",equalTo(false)).
                body("message.key",equalTo("incorrect_password"));
    }
    @Test
    public void checkNonExistenUserLogin(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecUniq(404));

        //With POJO
        RequestLogin requestLogin = new RequestLogin(WRONG_USERNAME,WRONG_PASSWORD,"569450","569450");
        ResponseNonExistentUserLogin response = given().
                body(requestLogin).
                when().
                post("/authenticatePlayer").
                then().log().all().extract().as(ResponseNonExistentUserLogin.class);

        Assert.assertEquals(response.getSuccess(),false);
        Assert.assertEquals(response.getMessage().getKey(),"document_not_found");

        //Without POJO
        given().
                body(new File("src/main/java/jsons/nonExistentUserLogin.json")).
                when().
                post("/authenticatePlayer").
                then().log().all().
                assertThat().
                body("success",equalTo(false)).
                body("message.key",equalTo("document_not_found"));

    }

    @Test
    public void accessToken() {
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());

        String token = given().
                contentType(ContentType.JSON).
                body(new File("src/main/java/jsons/login.json")).
                when().
                post("/authenticatePlayer").
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
