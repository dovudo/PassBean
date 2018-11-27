import com.AppBoot;
import com.Model.Unit;
import com.Service.TimeService;
import com.Service.TokenService;
import com.dao.UnitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.client.ClientHttpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestDataBase {

    private void testDb() {

/*

    try {
        URL site = new URL("https://www.phrases.org.uk/meanings/proverbs.html");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(site.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            if(inputLine.contains("href="))
                System.out.println(inputLine);
        Unit u = new Unit(ts.gen_email(),inputLine,ts.gen_token(),time.get_timestamp_long());
        ds.save(u);
        in.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}
*/

    }
}