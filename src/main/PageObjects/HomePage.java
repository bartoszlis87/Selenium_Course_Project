package src.main.PageObjects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private static WebDriver driver;

    @BeforeEach
    @Given("user open https://prod-kurs.coderslab.pl/")
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @And("user click on SingIn button")




    @AfterEach
    public void quitDriver() {
        driver.quit();

    }

}
