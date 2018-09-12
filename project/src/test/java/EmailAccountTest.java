
import org.junit.jupiter.api.BeforeEach;


import java.time.LocalDate;

public class EmailAccountTest {

    EmailBuilder emailBuilder;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setUpTest() {

        this.emailBuilder = new EmailBuilder();


    }
}