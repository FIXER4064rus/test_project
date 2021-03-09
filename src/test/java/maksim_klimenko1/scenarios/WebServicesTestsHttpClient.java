package maksim_klimenko1.scenarios;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class WebServicesTestsHttpClient {
    HttpResponse response;
    private static String SERVICE_URL = "https://jsonplaceholder.typicode.com/users";

    @BeforeMethod(alwaysRun = true)
    public void SetUp() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest request = RequestBuilder.get(SERVICE_URL).build();
        response = httpClient.execute(request);


    }

    @AfterMethod(alwaysRun = true)
    public void shutDown() {

    }

    @Test
    public void testWebServiceStatus()  {
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void testWebServiceHeaders() {
        HttpEntity entity = response.getEntity();
        ContentType contentType = ContentType.getOrDefault(entity);
        String mimeType = contentType.getMimeType();
        Charset charset = contentType.getCharset();
        Assert.assertNotNull(entity);
        Assert.assertEquals(mimeType, "application/json");
        Assert.assertEquals(charset.toString(), "UTF-8");
        System.out.println("MimeType = " + mimeType);
        System.out.println("Charset  = " + charset);
    }


}
