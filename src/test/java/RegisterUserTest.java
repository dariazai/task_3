import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import page.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUserTest extends UiHelpers {
    private boolean userCreated;

    @Description("Регистрация нового пользователя. Позитивная проверка")
    @Test
    public void registerNewUserTest() {
        MainPage objMainPage = new MainPage(UiHelpers.driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegister();
        registration(UserData.PASSWORD);
        objLoginPage.waitLoad();
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.clickEnterButton();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        userCreated = true;
    }

    @Description("Регистрация нового пользователя. Проверка, что с паролем меньше 6 символов нельзя выполнить регистрацию")
    @Test
    public void registerUserWithNoValidPassword() {
        MainPage objMainPage = new MainPage(UiHelpers.driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegister();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        registration("fjhh");
        assertTrue(objRegisterPage.isHeaderDisplayed());
        userCreated = false;
    }

    @AfterEach
    public void afterEach() {
        if (userCreated) {
            UserHelpers userHelpers = new UserHelpers();
            userHelpers.deleteUser();
        }
    }

    @Step("Регистрация. Ввод данных")
    public void registration(String password) {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.setEmail(UserData.EMAIL);
        objRegisterPage.setField(UserData.NAME);
        objRegisterPage.setPassword(password);
        objRegisterPage.clickRegisterButton();
    }
}
