package com.micha.step_definitions.login;

import com.micha.step_definitions.hooks.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStepDef {

    private final World world;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public LoginStepDef(World world) {
        this.world = world;
    }

    @Given("that the user enters valid data")
    public void thatTheUserEntersValidData() {
    }

    @When("I complete the transaction")
    public void iCompleteTheTransaction() {
        
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
    }
}
