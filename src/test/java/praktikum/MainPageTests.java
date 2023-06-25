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
import praktikum.pageobject.MainPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
    @DisplayName("Таб 'Булки'")
    public void bunTest() {
        objHomePage.clickFillingButton();
        objHomePage.clickBunButton();
        String newBreadText = objHomePage.getBunText();
        assertThat(newBreadText, is("Булки"));
    }

    @Test
    @DisplayName("Таб 'Соусы'")
    public void sauceTest() {
        objHomePage.clickSauceButton();
        String newSauceText = objHomePage.getSauceText();
        assertThat(newSauceText, is("Соусы"));
    }

    @Test
    @DisplayName("Таб 'Начинки'")
    public void fillingTest() {
        objHomePage.clickFillingButton();
        String newFillingText = objHomePage.getFillingText();
        assertThat(newFillingText, is("Начинки"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
