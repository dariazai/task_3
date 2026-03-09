import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUserTest extends UiHelpers {

    @Description("Регистрация нового пользователя. Позитивная проверка")
    @Test
    public void registerNewUserTest() {
        //Переходим на главную страницу сайта и нажимаем кнопку "Личный кабинет"
        MainPage objMainPage = new MainPage(UiHelpers.driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        //Нажимаем кнопку "Зарегистрироваться" и вводим данные пользователя
        objLoginPage.clickRegister();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.setEmail(UserData.EMAIL);
        objRegisterPage.setField(UserData.NAME);
        objRegisterPage.setPassword(UserData.PASSWORD);
        objRegisterPage.clickRegisterButton();
        objLoginPage.waitLoad();
        //Входим в личный кабинет для проверки, что регистрация прошла успешно
        objLoginPage.setEmail(UserData.EMAIL);
        objLoginPage.setPassword(UserData.PASSWORD);
        objLoginPage.clickEnterButton();
        //Проверяю что после успешного входа в "Личный кабинет" открывается главная страница
        assertTrue(driver.getCurrentUrl().contains(UrlData.URL_MAIN_PAGE));
        //Удаление созданого пользователя
        UserHelpers userHelpers = new UserHelpers();
        userHelpers.deleteUser();
    }

    @Description("Регистрация нового пользователя. Проверка, что с паролем меньше 6 символов нельзя выполнить регистрацию")
    @Test
    public void registerUserWithNoValidPassword() {
        MainPage objMainPage = new MainPage(UiHelpers.driver);
        objMainPage.clickPersonalAccount();
        LoginPage objLoginPage = new LoginPage(driver);
        //Нажимаем кнопку "Зарегистрироваться" и вводим данные пользователя
        objLoginPage.clickRegister();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.setEmail(UserData.EMAIL);
        objRegisterPage.setField(UserData.NAME);
        objRegisterPage.setPassword("oiuy");
        objRegisterPage.clickRegisterButton();
        assertTrue (objRegisterPage.isHeaderDisplayed());
    }
}
