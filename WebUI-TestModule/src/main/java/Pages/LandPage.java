package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandPage extends BasePage {

    public LandPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]")
    WebElement loginBtn;

    public void clickOnLoginBtn() {
        clickButton(loginBtn);
    }
}
