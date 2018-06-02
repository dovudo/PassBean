
import org.junit.Test;
import java.util.Random;

public class overloadTest {



    private String getRndString(Integer lenght) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < lenght) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @Test
    public void genTestSend(){
        for(int i = 0; i < 100; i++)
            connectToDb.sendSome(getRndString(6),getRndString(9));
    }
}
