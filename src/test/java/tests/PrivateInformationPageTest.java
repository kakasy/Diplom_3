package tests;

import client.UserClient;
import generator.UserDeserializer;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserRequest;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PrivateInformationPage;

import static org.junit.Assert.assertTrue;

public class PrivateInformationPageTest extends BaseTest {

    @DisplayName("Переход в Личный Кабинет")
    @Description("Должна отобразиться страница личного кабинета")
    @Test
    public void PersonalAccountClickTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PrivateInformationPage personalPage = new PrivateInformationPage(driver);

        UserRequest userRequest = UserRequest.createUser();
        Response response = UserClient.createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickAccountButton();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());
        mainPage.clickAccountButton();


        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue("Ошибка перехода", personalPage.isPersonalPageVisible());
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на Конструктор")
    @Description("Отображается конструктор на главной странице")
    @Test
    public void constructorCLickTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PrivateInformationPage personalPage = new PrivateInformationPage(driver);

        UserRequest userRequest = UserRequest.createUser();
        Response response = UserClient.createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickAccountButton();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());
        mainPage.clickAccountButton();
        personalPage.clickConstructorButton();


        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Description("Отображается конструктор на галвной странице")
    @Test
    public void logoClickTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PrivateInformationPage personalPage = new PrivateInformationPage(driver);

        UserRequest userRequest = UserRequest.createUser();
        Response response = UserClient.createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickAccountButton();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());
        mainPage.clickAccountButton();
        personalPage.clickLogo();


        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }

    @DisplayName("Выход из аккаунта")
    @Description("Отображается страница входа")
    @Test
    public void logOutTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PrivateInformationPage personalPage = new PrivateInformationPage(driver);

        UserRequest userRequest = UserRequest.createUser();
        Response response = UserClient.createUserRequest(userRequest);
        UserDeserializer.getDeserializeUser(response);

        mainPage.clickAccountButton();
        loginPage.userLogin(userRequest.getEmail(), userRequest.getPassword());
        mainPage.clickAccountButton();
        personalPage.clickLogo();


        UserClient.deleteUserRequest(UserClient.getAuthToken(response));

        assertTrue(mainPage.isMainPageVisible());
    }

}
