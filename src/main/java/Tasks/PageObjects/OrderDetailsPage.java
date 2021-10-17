package Tasks.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderDetailsPage {
    private static WebDriver driver;

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    private WebElement continueButtonAddresses;

    @FindBy(xpath = "//div[@class='delivery-options']//span[@class='h6 carrier-name']")
    private List<WebElement> shippingMethods;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement continueButtonShippingMethod;

    @FindBy(xpath = "//div[@class='payment-options ']//label/span")
    private List<WebElement> paymentOtions;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Order with an obligation to pay')]")
    private WebElement orderButton;

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButtonAddresses() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(continueButtonAddresses));
        continueButtonAddresses.click();
    }

    public void choiceShippingMethod(String method) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(shippingMethods));
        for (WebElement shippingMethod : shippingMethods) {
            if (shippingMethod.getText().contains(method)) {
                shippingMethod.click();
                break;
            }
        }
    }

    public void clickContinueButtonShippingMethod() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(continueButtonShippingMethod));
        continueButtonShippingMethod.click();
    }

    public void choicePaymentOtions(String payment) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='payment-options ']//label/span"))));
        for (WebElement paymentOtion : paymentOtions) {
            if (paymentOtion.getText().contains(payment)) {
                paymentOtion.click();
                break;
            }
        }
    }

    public void clickOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(orderButton));
        agreeCheckbox.click();
        orderButton.click();
    }
}
