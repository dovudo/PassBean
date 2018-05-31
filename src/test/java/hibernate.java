import com.dov.pass.service.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class hibernate {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        //tag::setUpValidator[]
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        //end::setUpValidator[]
    }

    @Test
    public void validate() {
        //tag::validate[]
        Car car = new Car( null, true );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
        //end::validate[]
    }

    @Test
    public void testEmail(){
        Car car = new Car(null, true);
        car.setEmail("dovjobs@gmail.com");

    }

    @Test
    public void validateProperty() {
        //tag::validateProperty[]
        Car car = new Car( null, true );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validateProperty(
                car,
                "manufacturer"
        );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
        //end::validateProperty[]
    }

    @Test
    public void validateValue() {
        //tag::validateValue[]
        Set<ConstraintViolation<Car>> constraintViolations = validator.validateValue(
                Car.class,
                "manufacturer",
                null
        );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
        //end::validateValue[]

    }

}
