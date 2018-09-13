import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailClientTest {

    EmailBuilder emailBuilder;
    EmailClient emailClient;
    EmailAccount emailAccount;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setUpTest() {

        this.emailBuilder = new EmailBuilder();
    }

    @Test
    public void setEmailService(EmailService emailService)throws Exception{
    }

    @Test
    public void ValidAddress(String emailAddress)throws Exception{
        
    assertEquals("user", emailAccount.getUser());
    assertEquals("ffm",emailAccount.getDomain());
    }

    @Test
    public void validEmail(Email email){

    }

    @Test
    public void verifyListEmail(EmailAccount account){

    }

    @Test
    public void SendEmail(Email email){

    }

    @Test
    public void creatAccount(){

    }
}
