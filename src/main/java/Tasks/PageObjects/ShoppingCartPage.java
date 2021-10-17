package Tasks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
    private static WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButtom;

    public ShoppingCartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButtom));
        proceedToCheckoutButtom.click();
    }
}
