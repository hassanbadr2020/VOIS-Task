package apitUtilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class ApiRequestBuilder {

    private RequestSpecification getBuildApiRequest(String baseUri) {
        RequestSpecification request;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUri);
        builder.setContentType(ContentType.JSON);
        builder.addHeader("Content-Type", "application/json");
        builder.addHeader("Accept", "application/json");
        RequestSpecification requestSpec = builder.build();
        request = RestAssured.given().spec(requestSpec);
        return request;
    }

    public Response performRequest(String baseURI, String path, String requestMethod, JSONObject body, String parameterType, JSONObject parameters, JSONObject headers) {

        RequestSpecification request = getBuildApiRequest(baseURI);

        //Headers
        if (headers != null) {
            headers.forEach(((key, value) -> {
                request.header(key.toString(), value.toString());
            }));
        }

        //Parameters
        if (parameterType != null && parameters != null) {
            if (parameterType.equals("Query")) {
                request.queryParams(parameters);
            } else if (parameterType.equals("Form")) {
                request.formParams(parameters);
            }
        } else {
            System.out.println("the parameters have not been sent");
        }
        System.out.println(baseURI + path);
        //Body
        if (body != null) {
            request.body(body);
        } else {
            System.out.println("the body has not been sent");
        }

        //Request Method Type
        if (requestMethod.equals("GET")) {
            return request.get(path);
        } else if (requestMethod.equals("POST")) {
            return request.post(path);
        } else if (requestMethod.equals("PUT")) {
            return request.put(path);
        } else if (requestMethod.equals("DELETE")) {
            return request.delete(path);
        } else if (requestMethod.equals("PATCH")) {
            return request.patch(path);
        } else {
            return request.get(path);
        }
    }

}
