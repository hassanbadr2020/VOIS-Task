package stepDefinitions.testSteps;

import apiRequests.ApiRequests;
import base.Base;
import io.cucumber.java8.En;
import org.apache.velocity.runtime.directive.Parse;
import org.junit.Assert;

public class GetAllPosts implements En {
    private Base base;
    ApiRequests apiRequests =new ApiRequests();
    public GetAllPosts(Base base) {
        this.base =base;
        And("^the number of Posts is \"([^\"]*)\"$", (Integer numberOfPosts) -> {
            Integer actualNumberOfPosts = base.response.jsonPath().getList("id").size();
            Assert.assertEquals(actualNumberOfPosts,numberOfPosts);
        });
        Given("^User send a get request to list all posts$", () -> {
            base.response =apiRequests.getAllCreatedPosts();
        });
    }
}
