package maksim_klimenko1.scenarios;

import maksim_klimenko1.reporting.CustomLogger;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebServicesTestsRestAssured {
    private static String SERVICE_URL = "https://jsonplaceholder.typicode.com/users";
    private Response response;
    private static int EXPECTED_RESULT = 10;
    private static String SEARCH_PATTERN = "username";

    @BeforeMethod(alwaysRun = true)
    public void SetUp() {
        response = RestAssured.get(SERVICE_URL).andReturn();
    }

    @AfterMethod(alwaysRun = true)
    public void shutDown() {

    }

    @Test
    public void testWebServiceStatus() {
        CustomLogger.info("Performing GET");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void testWebServiceHeaders() {
        CustomLogger.info("Performing GET");
        String header = response.getHeader("Content-Type");
        CustomLogger.info("Getting header");
        Assert.assertEquals(header, "application/json; charset=utf-8");
    }

    @Test
    public void testWebServiceBody() {
        CustomLogger.info("Performing GET");
        String text = response.getBody().asString();
        CustomLogger.info("Getting body");
        try {
            String[] stringSeparators = text.split(SEARCH_PATTERN);
            CustomLogger.info("Checking as string");
            Assert.assertEquals(stringSeparators.length - 1, EXPECTED_RESULT);
        } catch (Exception e) {
            CustomLogger.error("Failed at:", e);
            throw new RuntimeException(e);
        }
        try {
            RestAssured.defaultParser = Parser.JSON;
            List<String> jsonResponse = response.jsonPath().getList(SEARCH_PATTERN);
            CustomLogger.info("Checking as array");
            Assert.assertEquals(jsonResponse.size(), EXPECTED_RESULT);
        } catch (Exception e) {
            CustomLogger.error("Failed at:", e);
            throw new RuntimeException(e);
        }
    }
}