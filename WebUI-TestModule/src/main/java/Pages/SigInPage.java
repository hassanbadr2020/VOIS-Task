package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigInPage extends BasePage {

    public SigInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(name = "SubmitLogin")
    WebElement loginBtn;

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    @FindBy(xpath = "//div[@id='center_column']/div[1]//li")
    WebElement errorMessagelogin;

    @FindBy(xpath = "//div[@id='create_account_error']//li")
    WebElement errorMessageCreateAccount;

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

    public String getActualMessage(String page) {
        String actualErrorMessage = null;
        if (page.equals("login")) {
            actualErrorMessage = getTextElement(errorMessagelogin);
        } else {
            actualErrorMessage = getTextElement(errorMessageCreateAccount);
        }
        return actualErrorMessage;
    }


}
