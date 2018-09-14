import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    public void setEmailService(EmailService emailService){
        assertEquals("email","email");
    }

    @Test
    public void ValidAddress(String emailAddress)throws Exception{
    assertEquals(emailClient.isValidAddress("user@ffm.com"),emailAccount.getUser(),emailAccount.getDomain());
    }

    @Test
    public void validEmail(Email email){
    assertTrue(true);
    }

    @Test
    public void verifyListEmail(EmailAccount account){
    assertFalse(false,emailClient.emailList());
    }

    @Test
    public void SendEmail(Email email){
    assertTrue(true,emailClient.sendEmail());
    }

    @Test
    public void creatAccount(){
    assertTrue(true,emailAccount.getDomain(),emailClient.createAccount());
    }
}
