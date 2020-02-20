package shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    Person lucy = new Person();
    Person sean = new Person();
    private String messageFromSean;

    @Given("Lucy is {int} metres from Sean")
    public void lucy_is_metres_from_Sean(Integer distance) {

        lucy.setLocation(distance);
        sean.setLocation(0);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        sean.shout(message);
        messageFromSean = message;
     }

    @Then("Lucy should hear Sean's message")
    public void lucy_should_hear_Sean_s_message() {
        assertEquals(asList(messageFromSean), lucy.getMessagesHeard());
    }
}
