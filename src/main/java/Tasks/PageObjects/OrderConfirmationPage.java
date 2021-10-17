package Tasks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage {
    private static WebDriver driver;

    @FindBy(xpath = "//td/span[contains(text(),'Total')]/following::td")
    private WebElement total;

    @FindBy(xpath = "//li[contains(text(),'Order reference')]")
    private WebElement reference;

    @FindBy(xpath = "//*[@class='account']")
    private WebElement accountButton;

    String totalString;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTotal() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(total));
        totalString = total.getText();
        return totalString;
    }

    public String getReference() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(reference));
        return reference.getText().replaceAll("Order reference: ", "");
    }

    public void clickAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(accountButton));
        accountButton.click();
    }
}
