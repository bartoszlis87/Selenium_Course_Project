package Tasks.PageObjects;

import org.openqa.selenium.WebDriver;

public class AddToNewUser {

    private static WebDriver driver;

    public AddToNewUser(WebDriver driver) {
        this.driver = driver;
    }

    public static AddToNewUser goTo(String codersLabAdressWebsite) {
        driver.navigate().to(codersLabAdressWebsite);
        return new AddToNewUser(driver);
    }

    public void click() {
    }
}
