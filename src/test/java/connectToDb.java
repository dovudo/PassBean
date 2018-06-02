import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpHeaders.USER_AGENT;

public class connectToDb {

    private static final String URL = "http://localhost:8080/connect/addempl";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static HttpPost post = new HttpPost(URL);
    private static HttpClient client = new DefaultHttpClient();

    public static void sendSome (String firstname, String secondname) {
        post.setHeader("User-Agent",USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("firstname",firstname));
        urlParameters.add(new BasicNameValuePair("lastname", secondname));
        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpResponse response = client.execute(post);
            System.out.println("\nSending 'POST' request to URL : " + URL);
            System.out.println("Post parameters : " + post.getEntity());
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
                System.out.println(result.toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
