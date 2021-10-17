package Tasks.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderHistoryPage {
    private static WebDriver driver;

    @FindBy (xpath = "//tbody/tr/*[@scope='row' or @class='text-xs-right' or ./span]")
    private List<WebElement> referenceTotalStatus;

    public OrderHistoryPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkOrder(String reference, String total) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(referenceTotalStatus));
        By totalPrice = By.xpath("//tbody/tr[./th[contains(text(),'" + reference + "')]]/*[@class='text-xs-right']");
        By status = By.xpath("//tbody/tr[./th[contains(text(),'" + reference + "')]]/*[./span]");
        return (driver.findElement(totalPrice).getText().equals(total) &&
                driver.findElement(status).getText().contains("Awaiting check payment"));
    }
}
