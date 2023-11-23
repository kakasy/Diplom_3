package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static generator.DriverConfig.createDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp() {
        driver = createDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
