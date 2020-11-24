package stepDefinitions.TestSteps;

import Pages.RegistrationPage;
import Pages.SigInPage;
import Utilities.MethodHelper;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Registration extends Base {
    private Base base;
    MethodHelper methodHelper = new MethodHelper();
    SigInPage sigInPage;
    RegistrationPage registrationPage;

    public Registration(Base base) {
        this.base = base;
    }

    @And("Redirected to the login page")
    public void redirectedToTheLoginPage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("authentication"));
    }

    @When("Enter email valid {string}")
    public void enterEmailValid(String email) {
        sigInPage = new SigInPage(base.driver);
        email = methodHelper.generateFakeEmail(email);
        sigInPage.validateEmail(email);
    }

    @And("Click on the Create An Account button")
    public void clickOnTheCreateAnAccountButton() {
        sigInPage = new SigInPage(base.driver);
        sigInPage.clickonCreateAnAccount();
    }

    @And("Redirected to continue registration page")
    public void redirectedToContinueRegistrationPage() {
//        Assert.assertTrue(base.driver.getCurrentUrl().contains("account-creation"));
    }

    @And("Fill all the required fields of personal information section {string} , {string}, {string} ,{string} and data of birth is {string}, {string} and {string} and {string} and {string}")
    public void fillAllTheRequiredFieldsOfPersonalInformationSectionAndDataOfBirthIsAnd(String gender, String firstName, String lastName, String password, String day, String month, String year, String newsLetter, String option) {
        registrationPage = new RegistrationPage(base.driver);
        registrationPage.selectGender(gender.toLowerCase());
        registrationPage.SendRestInfoOfPersonalInfo(firstName, lastName, password);
        registrationPage.selectDay(day);
        registrationPage.selectMonth(month);
        registrationPage.selectYear(year);
        registrationPage.selectNewsLetterOption(newsLetter, option);
    }

    @And("Fill all the required fields of the your Address section {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void fillAllTheRequeiredFieldsOfTheYourAddressSectionAnd(String address, String city, String state, String zipCode, String country, String phone, String alias) {
        registrationPage = new RegistrationPage(base.driver);
        registrationPage.getAddress(address, city, state, zipCode, country);
        registrationPage.getRestPhone(phone, alias);
    }

    @And("click on Register button")
    public void clickOnRegisterButton() {
        registrationPage = new RegistrationPage(base.driver);
        registrationPage.register();
    }

    @Then("the account has been created successfully")
    public void theAccountHasBeenCreatedSuccessfully() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("my-account"));
    }


}
