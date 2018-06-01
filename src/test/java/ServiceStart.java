import com.dov.pass.SampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(SampleController .class, args);
    }
}
