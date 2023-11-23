package generator;

import model.UserResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static org.hamcrest.core.IsEqual.equalTo;

public class UserDeserializer {

    public static UserResponse getDeserializeUser(Response response) {

        return response.then()
                .log().all()
                .assertThat()
                .body("success", equalTo(true))
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .as(UserResponse.class);
    }
}
