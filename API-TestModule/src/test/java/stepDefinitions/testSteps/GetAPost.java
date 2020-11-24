package stepDefinitions.testSteps;

import apiRequests.ApiRequests;
import base.Base;
import io.cucumber.java8.En;
import org.junit.Assert;

public class GetAPost implements En {
    private Base base;
    ApiRequests apiRequests = new ApiRequests();

    public GetAPost(Base base) {
        this.base = base;
        Given("^user send a request to get post with valid \"([^\"]*)\"$", (String postId) -> {
            base.response = apiRequests.getOnePost(postId);
        });
        And("^response body is empty$", () -> {
            Assert.assertNull(base.response.jsonPath().getString("id"));
        });
    }
}
