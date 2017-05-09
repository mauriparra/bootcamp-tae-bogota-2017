package bootcampAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage extends Page{

    @FindBy(id = "firstname")
    private WebElement firstnameForm;

    @FindBy(id = "lastname")
    private WebElement lastnameForm;

    @FindBy(id = "email_address")
    private WebElement emailForm;

    @FindBy(id = "region_idx")
    private WebElement regionForm;

    @FindBy(id = "cityx")
    private WebElement cityxForm;

    @FindBy(id = "password")
    private WebElement passwordForm;

    @FindBy(id = "confirmation")
    private WebElement confirmationForm;

    @FindBy(css = "div.buttons-set.form-buttons .button")
    private WebElement button;

    @FindBy(id = "is_subscribed")
    private WebElement is_subscribed;

    @FindBy(id = "id_accept_terms")
    private WebElement id_accept_terms;

    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    public ReturnCreateUserPage fillFormAlkomprar(String first, String last, String emailAddress, String state, String city, String password) {
        this.firstnameForm.sendKeys(first);
        this.lastnameForm.sendKeys(last);
        this.emailForm.sendKeys(emailAddress);
        super.createSelector(this.regionForm).selectByValue(state);
        super.createSelector(this.cityxForm).selectByValue(city);
        this.passwordForm.sendKeys(password);
        this.confirmationForm.sendKeys(password);
        this.is_subscribed.click();
        this.id_accept_terms.click();
        this.button.click();
        return PageFactory.initElements(this.driver, ReturnCreateUserPage.class);
    }

}
