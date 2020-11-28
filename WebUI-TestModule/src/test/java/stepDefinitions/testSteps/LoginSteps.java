package stepDefinitions.testSteps;

import Pages.LandPage;
import Pages.SigInPage;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends Base {
    private Base base;
    SigInPage sigInPage;
    LandPage landPage;

    public LoginSteps(Base base) {
        this.base = base;
    }

    @Given("A user in the home page")
    public void iInHomePage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("automationpractice"));
    }

    @And("click on the signIn button")
    public void clickOnTheSigninBtn() {
        landPage = new LandPage(base.driver);
        landPage.clickOnLoginBtn();
    }

    @When("user enter name and password in fields {string} {string}")
    public void enterUserNameAndPassword(String email, String password) {
        sigInPage = new SigInPage(base.driver);
        sigInPage.login(email, password);
    }

    @And("click on the login button")
    public void clickOnTheLoginBtn() {
        sigInPage = new SigInPage(base.driver);
        sigInPage.clickOnLoginBtn();
    }

    @Then("I'm in the home page")
    public void iMInTheHomePage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("my-account"));
    }

    @Then("system displays an error message says {string}")
    public void systemDisplaysAnErrorMessageSays(String errorMessage) {
        sigInPage = new SigInPage(base.driver);
        sigInPage.getActualMessage();
        Assert.assertEquals(errorMessage, sigInPage.getActualMessage());
    }
}
