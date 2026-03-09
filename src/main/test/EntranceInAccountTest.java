import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
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
    }

    @Description("Проверка входа в личный кабинет на главной странице, с помощью кнопки Войти в аккаунт")
    @Test
    public void entranceFromMainPageAndButtonLogInToYourAccountTest() {
        //Создаем нового пользователя
        createUser.createNewUser(UserData.EMAIL, UserData.PASSWORD, UserData.NAME)
                .then()
                .statusCode(SC_OK)
                .body("success", equalTo(true));
        //Переходим на главную страницу и нажимаем кнопку "Войти в аккаунт"
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickEntranceInAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        //Вводим логин и пароль
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.clickEnterButton();
        //Проверяем, что после успешной авторизации отображается главная страница
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
    }

    @Description("Проверка входа в личный кабинет на главной странице, с помощью кнопки Личный кабинет")
    @Test
    public void entranceFromMainPageAndButtonPersonalAccountTest() {
        createUser.createNewUser(UserData.EMAIL, UserData.PASSWORD, UserData.NAME)
                .then()
                .statusCode(SC_OK)
                .body("success", equalTo(true));
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.clickEnterButton();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
    }

    @Description("Проверка входа в личный кабинет со страницы регистрации по кнопке Войти")
    @Test
    public void entranceFromRegisterPageAndLoginButtonTest() {
        createUser.createNewUser(UserData.EMAIL, UserData.PASSWORD, UserData.NAME)
                .then()
                .statusCode(SC_OK)
                .body("success", equalTo(true));
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegister();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickLoginButton();
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.clickEnterButton();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
    }

    @Description("Проверка входа в личный кабинет со страницы регистрации по кнопке Войти")
    @Test
    public void entranceFromRecoverPasswordPageTest() {
        createUser.createNewUser(UserData.EMAIL, UserData.PASSWORD, UserData.NAME)
                .then()
                .statusCode(SC_OK)
                .body("success", equalTo(true));
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickFailPassword();
        ForgotPage objForgotPage = new ForgotPage(driver);
        objForgotPage.clickEnterButton();
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.clickEnterButton();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
    }

    @AfterEach
    public void afterEach() {
        createUser.deleteUser();
    }
}


