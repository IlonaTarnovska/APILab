package framework.services;

import framework.models.login.LoginRequestModel;
import framework.models.login.LoginResponseModel;
import lombok.Data;

import static framework.endpoints.Endpoints.AUTH_LOGIN;
import static io.restassured.RestAssured.given;

public class ShopServices {

    public static LoginResponseModel logIn(LoginRequestModel requestModel) {
        return given()
                .body(requestModel)
                .post(AUTH_LOGIN)
                .then()
                .statusCode(200)
                .extract()         /*переходить з ріквеста на ріспонс*/
                .body()
                .as(LoginResponseModel.class);
    }
}
