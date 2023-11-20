package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static generator.DriverConfig.createDriver;

public class RegisterPageTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        driver = createDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }


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


    @After
    public void teardown() {
        driver.quit();
    }
}
