import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import page.UserData;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.hamcrest.Matchers.equalTo;

public class UserHelpers {




   @Step("Создание нового пользователя")
   public Response createNewUser(String email, String password, String name) {
       RestAssured.baseURI = "https://stellarburgers.education-services.ru";
       UserParameter userParameter = new UserParameter(email, password, name);
       Response response =
               given()
                       .contentType("application/json")
                       .body(userParameter)
                       .when()
                       .post("/api/auth/register");
       return response;
   }
    @Step("Авторизация пользователя")
    public static  Response authUser(String email, String password, String name) {
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
        UserParameter userParameter = new UserParameter(UserData.EMAIL, UserData.PASSWORD, UserData.NAME);
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(userParameter)
                        .when()
                        .post("/api/auth/login");
        return response;
            }

        @Step("Удаление пользователя")
        public Response deleteUser() {
            RestAssured.baseURI = "https://stellarburgers.education-services.ru";
            String accessToken = authUser(UserData.EMAIL, UserData.PASSWORD, UserData.NAME).jsonPath()
                    .getString("accessToken");
            Response response =
                    given()
                            .header("Authorization", accessToken)
                            .and()
                            .when()
                            .delete("/api/auth/user");
            response.then()
                    .statusCode(SC_ACCEPTED)
                    .body("success", equalTo(true))
                    .body("message", equalTo("User successfully removed"));
            return response;
        }
}
