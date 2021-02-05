package bouncer77;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class HttpExample {
    public static void main(String[] args) throws IOException {


        HttpClient httpClient = HttpClients.createDefault();

        // GET
        HttpGet httpGet = new HttpGet("http://yandex.ru");
        HttpResponse httpResponse = httpClient.execute(httpGet);

        String body = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(body);

        // POST
        HttpPost httpPost = new HttpPost("http://yandex.ru");
        httpPost.setHeader("header1", "value1");
        httpResponse = httpClient.execute(httpPost);

        body = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(body);
    }
}
