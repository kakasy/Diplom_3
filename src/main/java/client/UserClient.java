package client;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import model.UserRequest;

import static io.restassured.RestAssured.given;

public class UserClient {

    public final static String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public final static String CREATE_USER_URL = "api/auth/register";
    public final static String DELETE_USER_URL = "api/auth/user";


    @Step("Создание пользователя")
    public static Response createUserRequest(UserRequest userRequest) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .body(userRequest)
                .baseUri(BASE_URL)
                .when()
                .filter(new AllureRestAssured())
                .post(CREATE_USER_URL);

    }

    @Step("Удаление пользователя")
    public static Response deleteUserRequest(String accessToken) {
        return given()
                .log().all()
                .header("authorization", "accessToken")
                .baseUri(BASE_URL)
                .when()
                .filter(new AllureRestAssured())
                .delete(DELETE_USER_URL);
    }

    @Step("Получение токена")
    public static String getAuthToken(Response response) {
        return response
                .body()
                .jsonPath()
                .get("accessToken");
    }

}
