import com.dov.pass.dao.dbpersist;
import com.dov.pass.service.employee;
import org.junit.Test;
import com.dov.pass.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class sendBD {

    @Autowired
    private static dbpersist dp;

    public static void main(String[] args) {
        employee em = new employee("alex","Lee");
        dp.save(em);
    }
}

