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
import praktikum.pageobject.MainPage;
import praktikum.pageobject.LoginPage;
import praktikum.pageobject.ProfilePage;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.data.BaseData.EMAIL_TEST;
import static praktikum.data.BaseData.PASSWORD_TEST;

public class ProfilePageTest {
    private WebDriver driver;
    MainPage objMainPage;
    LoginPage objloginPage;
    ProfilePage objProfilePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to(BaseData.BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_SECONDS_TIMEOUT));
        objMainPage = new MainPage(driver);
        objMainPage.clickLogInYourAccountButton();
        objloginPage = new LoginPage(driver);
        objloginPage.login(EMAIL_TEST, PASSWORD_TEST);
        objMainPage.clickPersonalAccountButton();
        objProfilePage = new ProfilePage(driver);
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу по клику на 'Конструктор' из ЛК")
    public void redirectConstructorTest() {
        objProfilePage.expectationConstructorButton();
        objProfilePage.clickConstructorLink();
        String newDesignerText = objMainPage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Проверка перехода на главную по клику на логотип 'Stellar Burgers' из ЛК")
    public void redirectStellarBurgersTest() {
        objProfilePage.expectationStellarBurgersButton();
        objProfilePage.clickStellarBurgersButton();
        String newDesignerText = objMainPage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void LogoutTest() {
        objProfilePage.expectationExitButton();
        objProfilePage.clickExitButton();
        objloginPage.expectationEnterText();
        String newGetEnterText = objloginPage.getEnterText();
        assertThat(newGetEnterText, is("Вход"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
