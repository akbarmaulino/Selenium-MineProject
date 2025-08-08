package WebsiteTesting.Steps;

import org.openqa.selenium.WebDriver;

import WebsiteTesting.Helper.hook;
import WebsiteTesting.Pages.LoginPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;
    LoginPages loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver = hook.getDriver();
        loginPage = new LoginPages(driver);
        loginPage.verifyURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    
    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        loginPage.verifyURL("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
    
}