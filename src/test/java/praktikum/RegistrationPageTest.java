package praktikum;

import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.user.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.data.BaseData;
import praktikum.pageobject.MainPage;
import praktikum.pageobject.LoginPage;
;
import praktikum.pageobject.RegistrationPage;
import praktikum.user.UserGenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationPageTest {
    private WebDriver driver;
    User user;
    MainPage objMainPage;
    RegistrationPage objRegistrationPage;
    LoginPage objLoginPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to(BaseData.BASE_URL);
        objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterButton();
        objRegistrationPage = new RegistrationPage(driver);

    }

    @Test
    @DisplayName("Проверка ошибки при регистрации с некорректным паролем (менее 6-ти символов)")
    public void createUserErrorPasswordTest() {
        objRegistrationPage.registrationMethod("Test", "test@test.com", "Leto");
        String newGetErrorText = objRegistrationPage.getErrorText();
        assertThat(newGetErrorText, is("Некорректный пароль"));
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void createUserTest() {
        User user = UserGenerator.random();
        objRegistrationPage.registrationMethod(user.getName(), user.getEmail(), user.getPassword());
        objLoginPage.expectationEnterText();
        String newGetEnterText = objLoginPage.getEnterText();
        assertThat(newGetEnterText, is("Вход"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
