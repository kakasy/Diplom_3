package tests;

import client.UserClient;
import generator.UserDeserializer;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PrivateInformationPage;


import static generator.DriverConfig.createDriver;

public class PrivateInformationPageTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        driver = createDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

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

        Assert.assertTrue("Ошибка перехода", personalPage.isPersonalPageVisible());
        UserClient.deleteUserRequest(UserClient.getAuthToken(response));
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
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
