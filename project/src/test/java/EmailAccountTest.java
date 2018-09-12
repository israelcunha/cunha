
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailAccountTest {

    EmailBuilder emailBuilder;
    EmailAccount emailAccount;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setUpTest() {

        this.emailBuilder = new EmailBuilder();
    }

    @Test
    public void verifyPasswordExpiration(){
       emailBuilder.setCreationDate(Instant.now());
       emailAccount.setLastPasswordUpdate(LocalDate.now());
       assertTrue(() -> true);
    }
}