package apiRequests;

import Environments.EnviromnetHandler.DataManager;
import apitUtilities.ApiRequestBuilder;
import apitUtilities.Endpoints;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class ApiRequests {


    DataManager dataManager = new DataManager();
    ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    Endpoints endpoints = new Endpoints();


    public Response createPost(JSONObject body) {
        return apiRequestBuilder.performRequest(dataManager.getApiUri(), endpoints.getPosts(), "POST", body, null, null, null);
    }

    public Response getAllCreatedPosts() {
        return apiRequestBuilder.performRequest(dataManager.getApiUri(), endpoints.getPosts(), "GET", null, null, null, null);
    }

    public Response getOnePost(String postId) {
        return apiRequestBuilder.performRequest(dataManager.getApiUri(), endpoints.getPosts() + "/" + postId, "GET", null, null, null, null);
    }

}
