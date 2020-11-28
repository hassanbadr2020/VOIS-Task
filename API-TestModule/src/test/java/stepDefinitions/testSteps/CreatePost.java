package stepDefinitions.testSteps;

import apiRequests.ApiRequests;
import apitUtilities.ApiMethodHelper;
import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class CreatePost extends Base implements En {
    ApiMethodHelper apiMethodHelper = new ApiMethodHelper();
    ApiRequests apiRequests = new ApiRequests();
    private Base base;

    public CreatePost(Base base) {
        this.base = base;
        Given("^I send post request with valid credentials$", (DataTable dataTable) -> {
            JSONObject body = apiMethodHelper.covertDTtoJO(dataTable);

            System.out.println(body);
            JSONObject headers = new JSONObject();
            headers.put("Accept", "application/json");
            base.response = apiRequests.createPost(body);

        });
        Then("^status code is \"([^\"]*)\"$", (String statusCode) -> {
            Assert.assertEquals(Integer.parseInt(statusCode), base.response.statusCode());
        });
        And("^response error message is \"([^\"]*)\"$", (String expectedMessage) -> {
            Assert.assertEquals(base.response.jsonPath().getString("errors.message"), expectedMessage);
        });
        Then("^response body matches \"([^\"]*)\" in Api contract$", (String schemaName) ->
        {
            apiMethodHelper.validateSchema(schemaName, base.response);
        });
        And("^the users id of the created body is \"([^\"]*)\"$", (String expectedValue) -> {
            Assert.assertEquals(base.response.jsonPath().getString("userId"), expectedValue);
        });
    }
}
