package Tasks.Steps;

import Tasks.PageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AdressSteps {

    private WebDriver driver;
    private YourAccountPage yourAccountPage;
    private AdressPage adressPage;
    private NewAddressPage newAddressPage;

    String email = "123123@wp.pl";
    String password = "Q123Q23";
    String codersLabAdressWebsite = "https://mystore-testlab.coderslab.pl";

    @BeforeEach
    @Given("user open coderslab website https://mystore-testlab.coderslab.pl")
    public void openWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(codersLabAdressWebsite);
    }

    @And("user clicks on SignIn button and add email and password")
    public void logIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSingIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail(email);
        logInPage.fillPassword(password);
        logInPage.clickSingIn();
    }

    @When("click Addres after logIn")
    public void clickAddresses() {
        yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickAdresButtom();
    }

    @And("click in Create new address")
    public void clickAddAddresses() {
        adressPage = new AdressPage(driver);
        adressPage.clickCreateNewAdress();
    }

    @And("adding values to the address fields (.*), (.*), (.*), (.*), (.*), (.*)")
    public void fillForm(String alias, String adress, String city, String postcode, String country, String phone) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillAliasField(alias);
        newAddressPage.fillAddressField(adress);
        newAddressPage.fillCityField(city);
        newAddressPage.fillPostcodeField(postcode);
        newAddressPage.fillCountryField(country);
        newAddressPage.fillPhoneField(phone);
        newAddressPage.clickSaveButton();
    }

    @Test
    @Then("adress (.*) added")
    public void addressAdded(String alias) {
        adressPage = new AdressPage(driver);
        Assertions.assertEquals("Address successfully added!", adressPage.getAlert());
        Assertions.assertTrue(adressPage.checkAddress(alias));
    }

    @And("click delete adress (.*)")
    public void clickDeleteAddress(String alias) {
        adressPage.clickDeleteAddress(alias);
    }

    @And("adress (.*) deleted")
    public void addressDeleted(String alias) {
        adressPage = new AdressPage(driver);
        assertEquals("Address successfully deleted!", adressPage.getAlert());
        assertFalse(adressPage.checkAddress(alias));
    }

    @AfterEach
    @And("browser closed")
    public void closeWindow() {
        driver.quit();
    }
}

