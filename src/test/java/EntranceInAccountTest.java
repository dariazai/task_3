import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.*;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntranceInAccountTest extends UiHelpers {
    static UserHelpers createUser;

    @BeforeAll
    public static void setUp() {
        createUser = new UserHelpers();
        createUser.createNewUser(UserData.EMAIL, UserData.PASSWORD, UserData.NAME)
                .then()
                .statusCode(SC_OK)
                .body("success", equalTo(true));
    }

    @Description("Проверка входа в личный кабинет на главной странице, с помощью кнопки Войти в аккаунт")
    @Test
    public void entranceFromMainPageAndButtonLogInToYourAccountTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickEntranceInAccount();
        login();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        assertTrue(objMainPage.isCreateButtonDisplayed());
    }

    @Description("Проверка входа в личный кабинет на главной странице, с помощью кнопки Личный кабинет")
    @Test
    public void entranceFromMainPageAndButtonPersonalAccountTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccount();
        login();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        assertTrue(objMainPage.isCreateButtonDisplayed());
    }

    @Description("Проверка входа в личный кабинет со страницы регистрации по кнопке Войти")
    @Test
    public void entranceFromRegisterPageAndLoginButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegister();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickLoginButton();
        login();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        assertTrue(objMainPage.isCreateButtonDisplayed());
    }

    @Description("Проверка входа в личный кабинет со страницы регистрации по кнопке Войти")
    @Test
    public void entranceFromRecoverPasswordPageTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickFailPassword();
        ForgotPage objForgotPage = new ForgotPage(driver);
        objForgotPage.clickEnterButton();
        login();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        assertTrue(objMainPage.isCreateButtonDisplayed());
    }

    @AfterAll
    static void afterEach() {
        createUser.deleteUser();
    }

    @Step("Вводим логин и пароль")
    private void login() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.clickEnterButton();
    }
}