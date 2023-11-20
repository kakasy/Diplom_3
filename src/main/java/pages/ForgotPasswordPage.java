package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;

    // Локатор кнопки Войти
    private static final By LOGIN_LINK = By.xpath("//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickLoginLink() {

        driver.findElement(LOGIN_LINK).click();
        waitForLoadingAnimation();
    }


    @Step("Ждем загрузки страницы")
    public void waitForLoadingAnimation() {

        ((JavascriptExecutor) driver)
                .executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
    }

}
