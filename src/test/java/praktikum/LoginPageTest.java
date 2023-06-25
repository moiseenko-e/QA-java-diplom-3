package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.data.BaseData;
import praktikum.data.WebDriverConfig;
import praktikum.pageobject.*;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest {
    private WebDriver driver;
    MainPage objMainPage;
    RegistrationPage objRegistrationPage;
    LoginPage objloginPage;
    ProfilePage objProfilePage;
    RecoveryPage objRecoveryPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to(BaseData.BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_SECONDS_TIMEOUT));
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        objMainPage = new MainPage(driver);
        objloginPage = new LoginPage(driver);
        objRegistrationPage = new RegistrationPage(driver);
        objProfilePage = new ProfilePage(driver);
        objRecoveryPage = new RecoveryPage(driver);
    }

    @Test
    @DisplayName("Проверка входа по кнопке 'Войти в аккаунт' на главной странице")
    public void loginHomePageTest() {
        objMainPage.clickLogInYourAccountButton();
        objloginPage.login("test0202@yandex.ru", "012345");
        objMainPage.clickPersonalAccountButton();
        objProfilePage.expectationAccountButton();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("Проверка входа по кнопке 'Личный кабинет'")
    public void accountButtonLoginTest() {
        objMainPage.expectationPersonalAccount();
        objMainPage.clickPersonalAccountButton();
        objloginPage.login("test0202@yandex.ru", "012345");
        objMainPage.expectationPersonalAccount();
        objMainPage.clickPersonalAccountButton();
        objProfilePage.expectationAccountButton();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("Проверка входа в форме регистрации по кнопке 'Войти'")
    public void registerPageLoginTest() {
        objMainPage.expectationPersonalAccount();
        objMainPage.clickLogInYourAccountButton();
        objloginPage.clickRegisterButton();
        objRegistrationPage.clickLoginButton();
        objloginPage.login("test0202@yandex.ru", "012345");
        objMainPage.expectationPersonalAccount();
        objMainPage.clickPersonalAccountButton();
        objProfilePage.expectationAccountButton();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @Test
    @DisplayName("Проверка входа в форме восстановления пароля по кнопке 'Войти'")
    public void forgotPasswordTest() {
        objMainPage.expectationPersonalAccount();
        objMainPage.clickPersonalAccountButton();
        objloginPage.clickForgotPasswordButton();
        objRecoveryPage.clickEnterButton();
        objloginPage.login("teste@example.com", "123422");
        objMainPage.expectationPersonalAccount();
        objMainPage.clickPersonalAccountButton();
        objProfilePage.expectationAccountButton();
        String newAccountLinkText = objProfilePage.getAccountLinkText();
        assertThat(newAccountLinkText, is("Профиль"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
