package tests;

import client.UserClient;
import generator.UserDeserializer;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserRequest;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static client.UserClient.createUserRequest;
import static model.UserRequest.createUser;
import static org.junit.Assert.assertTrue;


public class LoginPageTest extends BaseTest {

    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("После успешной авторизации происходит редирект на главную страницу")
    @Test
    public void loginWithLoginButtonTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        UserRequest userRequest = createUser();
        Response response = createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickAccountButton();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());

        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }


    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithPersonalAccountButtonTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        UserRequest userRequest = createUser();
        Response response = createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickLoginButton();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());

        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }


    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithRegisterFormButtonTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        UserRequest userRequest = createUser();
        Response response = createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickAccountButton();
        loginPage.clickRegister();
        registerPage.clickLoginLink();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());

        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }


    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithForgotPasswordFormButtonTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        UserRequest userRequest = createUser();
        Response response = createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);


        mainPage.clickAccountButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());

        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }

}
