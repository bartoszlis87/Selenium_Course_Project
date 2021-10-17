package Tasks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    private static WebDriver driver;

    @FindBy(xpath = "//h2[@itemprop='name']/a")
    private List<WebElement> itemsNames;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void choseItem(String find) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(itemsNames));
        for (WebElement item : itemsNames) {
            if (item.getText().contains(find)) {
                item.click();
                break;
            }
        }
    }
}
