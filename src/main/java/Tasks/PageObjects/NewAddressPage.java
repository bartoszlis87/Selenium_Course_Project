package Tasks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAddressPage {
    private static WebDriver driver;


    @FindBy (name = "alias")
    private WebElement aliasField;

    @FindBy (name = "address1")
    private WebElement addressField;

    @FindBy (name = "city")
    private WebElement cityField;

    @FindBy (name = "postcode")
    private WebElement postcodeField;

    @FindBy (name = "id_country")
    private WebElement countryField;

    @FindBy (name = "phone")
    private WebElement phoneField;

    @FindBy (xpath = "//section[@id='content']//button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAliasField(String alias) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(aliasField));
        aliasField.clear();
        aliasField.sendKeys(alias);
    }
    public void fillAddressField(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addressField));
        addressField.clear();
        addressField.sendKeys(address);
    }
    public void fillCityField(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(cityField));
        cityField.clear();
        cityField.sendKeys(city);
    }
    public void fillPostcodeField(String postcode) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(postcodeField));
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
    }
    public void  fillCountryField(String country) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(countryField));
        Select countries = new Select(countryField);
        countries.selectByVisibleText(country);
    }
    public void  fillPhoneField(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }
    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }
}
