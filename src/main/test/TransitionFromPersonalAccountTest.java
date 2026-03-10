import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.*;

import java.time.Duration;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransitionFromPersonalAccountTest extends UiHelpers {
    static UserHelpers createUser;

    @BeforeAll
    public static void setUp() {
        createUser = new UserHelpers();
    }

    @Description("Проверка, что по клику на кнопку Личный кабинет происходит переход в личный кабинет")
    @Test
    public void transitionToPersonalAccountTest() {
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
        objMainPage.clickPersonalAccount();
        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/account/profile")));

    }

    @Description("Проверка, что из личного кабинета, после клика на кнопку Конструктор происходит переход в контструктор")
    @Test
    public void transitionToConstructorTest() {
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
        objMainPage.clickPersonalAccount();
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickConstructorButton();
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        assertTrue(objMainPage.isHeaderDisplayed());

    }

    @Description("Проверка, что из личного кабинета, по клику на лого, происходит переход на главную страницу")
    @Test
    public void transitionToMainPageTest() {
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
        objMainPage.clickPersonalAccount();
        objMainPage.clickLogo();
        assertTrue(objMainPage.isHeaderDisplayed());

    }

    @Description("Проверка, что из личного кабинета, по клику на выход, происходит переход на страницу авторизации")
    @Test
    public void transitionToLoginPageTest() {
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
        objMainPage.clickPersonalAccount();
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.waitLoad();
        objProfilePage.clickExitButton();

        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/login")));
        assertTrue(objLoginPage.isEntranceDisplayed());

    }
    @AfterEach
    public void afterEach() {
        createUser.deleteUser();
    }
}
