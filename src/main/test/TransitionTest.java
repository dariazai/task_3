import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.*;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransitionTest extends UiHelpers {
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
        assertTrue(driver.getCurrentUrl().contains("/account/profile"));
        createUser.deleteUser();
    }

    @Description("Проверка, что по клику на кнопку Конструктор происходит переход в контструктор")
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
        createUser.deleteUser();
    }

    @Description("Проверка, что по клику на лого переходит на главную страницу")
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
        createUser.deleteUser();
    }
}
