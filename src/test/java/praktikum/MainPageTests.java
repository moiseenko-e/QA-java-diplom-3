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

import java.time.Duration;

public class MainPageTests {
    private WebDriver driver;
     MainPage objHomePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to(BaseData.BASE_URL);
        objHomePage = new MainPage(driver);
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Булки'")
    public void bunSelectedTest() {
        objHomePage.clickFillingButton(); // вышли из булок
        objHomePage.checkBunIsNotSelected();
        objHomePage.clickBunButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_SECONDS_TIMEOUT));
        objHomePage.getAndCheckAttributeValueIfTabBunsSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void sauceSelectedTest() {
        objHomePage.checkSauceIsNotSelected();
        objHomePage.clickSauceButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_SECONDS_TIMEOUT));
        objHomePage.getAndCheckAttributeValueIfTabSauceSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void fillingSelectedTest() {
        objHomePage.checkFillingIsNotSelected();
        objHomePage.clickFillingButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_SECONDS_TIMEOUT));
        objHomePage.getAndCheckAttributeValueIfTabFillingsSelected();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
