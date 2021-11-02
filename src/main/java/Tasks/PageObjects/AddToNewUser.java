package Tasks.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToNewUser {

    private static WebDriver driver;
    private WebDriverWait wait;

    By clickSignIn = By.cssSelector("#_desktop_user_info");

    public AddToNewUser(WebDriver driver) {
        this.driver = driver;
    }

    public AddToNewUser goTo(String codersLabAdressWebsite) {
        driver.navigate().to(codersLabAdressWebsite);
        wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(clickSignIn));
        return new AddToNewUser(driver);
    }

    public void click() {
    }
}
