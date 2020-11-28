package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandPage extends BasePage {

    public LandPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login")
    WebElement loginBtn;

    public void clickOnLoginBtn() {
        clickButton(loginBtn);
    }
}
