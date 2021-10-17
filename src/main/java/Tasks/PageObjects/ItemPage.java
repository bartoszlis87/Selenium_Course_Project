package Tasks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {
    private static WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement size;

    @FindBy(id = "quantity_wanted")
    private WebElement quantity;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement addToCartButtom;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButtom;

    @FindBy(className = "regular-price")
    private WebElement regularPrice;

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement currentPrice;

    @FindBy(className = "discount-percentage")
    private WebElement discount;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void choseSize(String mySize) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(size));
        Select sizes = new Select(size);
        sizes.selectByVisibleText(mySize);
    }

    public void choseQuantity(String num) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(quantity));
        for (int i = 0; i < 10; i++) {
            quantity.clear();
        }
        quantity.sendKeys(num);
    }

    public void addItemsToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addToCartButtom));
        addToCartButtom.click();
    }

    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButtom));
        proceedToCheckoutButtom.click();
    }

    public boolean checkDiscunt(double percent) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(regularPrice),
                ExpectedConditions.visibilityOf(currentPrice)));
        String stringRegularPrice = regularPrice.getText().replaceAll("[^0-9.]", "");
        String stringCurrentPrice = currentPrice.getText().replaceAll("[^0-9.]", "");
        double doubleRegularPrice = Double.parseDouble(stringRegularPrice);
        double doubleCurrentPrice = Double.parseDouble(stringCurrentPrice);
        if ((doubleRegularPrice - (doubleRegularPrice * percent/100)) == doubleCurrentPrice) {
            return true;
        } else {
            return false;
        }
    }
}

