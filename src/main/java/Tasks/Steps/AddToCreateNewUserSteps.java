package Tasks.Steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Tasks.PageObjects.AddToNewUser;


import java.util.concurrent.TimeUnit;

public class AddToCreateNewUserSteps {

    private WebDriver driver;



    @BeforeEach
    public void openToSignInWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.navigate().to("https://mystore-testlab.coderslab.pl");

    }

    @AfterEach
    public void closeWindow() {
        driver.quit();
    }

    @Test
    public void openToSignInWebsiteTest() {
        String codersLabURL = "https://mystore-testlab.coderslab.pl";
        AddToNewUser addToNewUser = new AddToNewUser(driver);
        addToNewUser.goTo(codersLabURL);

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "PrestaShop";

        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

}
