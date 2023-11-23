package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserRequest;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class RegisterPageTest extends BaseTest {

    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Должна отобразиться страница логина")
    @Test
    public void correctRegistrationTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegister();

        UserRequest correctUserDate = UserRequest.createUser();

        registerPage.registerUser(correctUserDate.getName(), correctUserDate.getEmail(), correctUserDate.getPassword());
        Assert.assertTrue("Пользователь не зарегистрирован", loginPage.isLoginPageVisible());
    }

    @DisplayName("Регистрация пользователя с некорректными паролем")
    @Description("Должно отобразиться сообщение Некорректный пароль")
    @Test
    public void incorrectRegistrationTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegister();

        UserRequest incorrectUserDate = UserRequest.createUserWithWrongPassword();

        registerPage.registerUser(incorrectUserDate.getName(), incorrectUserDate.getEmail(), incorrectUserDate.getPassword());
        Assert.assertTrue("Пользователь зарегистрирован", registerPage.isErrorMessageVisible());
    }

}
