import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import testdatabase.human;
import testdatabase.humanInterface;
import testdatabase.humans;

public class testaddtodb {

    human hh = new human();

    @Autowired
    humans hsave;

    @Test
    public void send(){
        hh.setFirstName("FUcktyyyy");
        hh.setLastName("you lsat");
        hh.setId(1243454577);
        hsave.save(hh);
    }
}
