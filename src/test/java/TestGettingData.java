import org.junit.Test;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;

import java.net.URI;

public class TestGettingData {

    private MockClientHttpRequest ping = new MockClientHttpRequest();

   // @Test
    
    void GetThroughApi(){
        ping.setURI(URI.create("localhost:8080/auth"));
    }
}
