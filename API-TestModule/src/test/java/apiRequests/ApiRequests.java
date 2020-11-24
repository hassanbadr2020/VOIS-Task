package apiRequests;

import Environments.EnviromnetHandler.EnvironmentHandler;
import apitUtilities.ApiRequestBuilder;
import apitUtilities.Endpoints;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class ApiRequests {


    EnvironmentHandler environmentHandler = new EnvironmentHandler();
    ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    Endpoints endpoints = new Endpoints();


    public Response createPost(JSONObject body) {
        return apiRequestBuilder.performRequest(environmentHandler.getApiUri(), endpoints.getPosts(), "POST", body, null, null, null);
    }

    public Response getAllCreatedPosts() {
        return apiRequestBuilder.performRequest(environmentHandler.getApiUri(), endpoints.getPosts(), "GET", null, null, null, null);
    }

    public Response getOnePost(String postId) {
        return apiRequestBuilder.performRequest(environmentHandler.getApiUri(), endpoints.getPosts() + "/" + postId, "GET", null, null, null, null);
    }

}
