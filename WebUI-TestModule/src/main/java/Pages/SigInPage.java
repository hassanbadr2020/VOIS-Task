package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigInPage extends BasePage {

    public SigInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
    WebElement loginBtn;

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;


    //Actions needed login fields
    public void login(String email, String password) {
        setTextElementText(emailField, email);
        setTextElementText(passwordField, password);
    }

    public void clickOnLoginBtn() {
        clickButton(loginBtn);
    }


    //Actions on create fields
    public void validateEmail(String email) {
        setTextElementText(emailCreate, email);
    }
    public void clickonCreateAnAccount() {
        clickButton(createAccountBtn);
    }

}
