package stepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("User is on login page");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
       System.out.println("User entered credentials");
    }

    @Then("user should see the home page")
    public void user_should_see_home_page() {
        System.out.println("User is on home page");
    }
}
