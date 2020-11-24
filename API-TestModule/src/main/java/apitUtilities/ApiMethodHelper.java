package apitUtilities;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiMethodHelper {
    /**
     * Method to convert the data-table to jsonObject
     * @param dataTable
     * @return
     */
    public JSONObject covertDTtoJO(DataTable dataTable) {
        JSONObject jsonObject = new JSONObject();
        List<Map<String, String>> tbaData = dataTable.asMaps(String.class, String.class);
        Iterator<Map<String, String>> iterator = tbaData.iterator();
        while (iterator.hasNext()) {
            for (Map.Entry pair : iterator.next().entrySet()) {
                jsonObject.put(pair.getKey(), pair.getValue());
            }
        }
        return jsonObject;
    }

    /**
     * To handle the comparision between two expected and actual JSON schema
     * @param schemaName
     * @param response
     */
    public void validateSchema(String schemaName, Response response) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaName));
    }
}
