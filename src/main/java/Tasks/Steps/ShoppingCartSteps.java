package Tasks.Steps;

import Tasks.PageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShoppingCartSteps {
    private WebDriver driver;

    private String itemName = "Hummingbird Printed Sweater";
    private String reference = null;
    private String total = null;

    private ItemPage itemPage;
    private MainPage mainPageShoppingCard;
    private LogInPage logInPageShoppingCard;
    private YourAccountPage accountPageShoppingCard;
    private SearchResultsPage searchResultsPage;
    private ShoppingCartPage shoppingCartPage;
    private OrderDetailsPage orderDetailsPage;
    private OrderConfirmationPage orderConfirmationPage;
    private OrderHistoryPage orderHistoryPage;

    String email = "123123@wp.pl";
    String password = "Q123Q23";
    String coderslabAdress = "https://mystore-testlab.coderslab.pl";

    @BeforeEach
    @Given("user open seccond coderslab website https://mystore-testlab.coderslab.pl")
    public void openWebsiteShoppingCard() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(coderslabAdress);
    }

    @And("user logIn website")
    public void logInShoppingCard() {
        mainPageShoppingCard = new MainPage(driver);
        mainPageShoppingCard.clickSingIn();

        logInPageShoppingCard = new LogInPage(driver);
        logInPageShoppingCard.fillEmail(email);
        logInPageShoppingCard.fillPassword(password);
        logInPageShoppingCard.clickSingIn();
    }

    @And("user find product Hummingbird Printed Sweater")
    public void findItem() {
        accountPageShoppingCard = new YourAccountPage(driver);
        accountPageShoppingCard.search(itemName);
    }

    @Test
    @When("user choose Hummingbird Printed Sweater to buy")
    public void choseItem() {
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.choseItem(itemName);

        itemPage = new ItemPage(driver);
        Assert.assertTrue(itemPage.checkDiscunt(20));
    }

    @And("user choose size M")
    public void choseSize() {
        itemPage.choseSize("M");
    }

    @And("user chose 5 products")
    public void choseQuantityOrder() {
        itemPage.choseQuantity("5");
    }

    @And("user add product to basket")
    public void addToCart() {
        itemPage.addItemsToCart();
    }

    @And("user go to checkout")
    public void proceedToCheckout() {
        itemPage = new ItemPage(driver);
        itemPage.clickProceedToCheckout();

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickProceedToCheckout();
    }

    @And("user confirms address")
    public void confirmAddress() {
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.clickContinueButtonAddresses();
    }

    @And("user choosing a pick up method - PrestaShop pick up in store")
    public void choiseMethod() {
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.choiceShippingMethod("PrestaShop");
        orderDetailsPage.clickContinueButtonShippingMethod();
    }

    @And("user choose a payment method- Pay by Check")
    public void selectPayment() {
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.choicePaymentOtions("Pay by Check");
    }

    @And("user clicks in order with an obligation to pay")
    public void clickOrder() {
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.clickOrderButton();
    }

    @Then("confirm screenshot order")
    public void printScreen() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Selenium\\CodersLab\\screenshot.png"));
    }

    @And("get total order")
    public void saveTotal() {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        reference = orderConfirmationPage.getReference();
        total = orderConfirmationPage.getTotal();
    }

    @And("go to history and details")
    public void goToOrderHistoryAndDetalis() {
        orderConfirmationPage.clickAccountButton();

        accountPageShoppingCard = new YourAccountPage(driver);
        accountPageShoppingCard.clickOrderHistoryAndDetalisButton();
    }

    @Test
    @And("check status Awaiting check payment and total order")
    public void checkStatusAndTotal() {
        orderHistoryPage = new OrderHistoryPage(driver);
        Assert.assertTrue(orderHistoryPage.checkOrder(reference,total));
    }

    @AfterEach
    @And("browser closed now")
    public void closeBrowser() {
        driver.quit();
    }
}
