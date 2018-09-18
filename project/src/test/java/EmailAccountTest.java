import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailAccountTest {

    EmailAccountBuilder emailAccountBuilder;

    @BeforeEach
    public void setUpTest() {

        this.emailAccountBuilder = new EmailAccountBuilder();
    }

    @Test
    public void test_User_Valid(){
        assertTrue(EmailClient.isValidAddress("i@i.com"));
    }

    @Test
    public void test_User_Invalid(){
        assertFalse(EmailClient.isValidAddress("@i.com"));
    }

    @Test
    public void test_Domain_Valid(){
        assertTrue(EmailClient.isValidAddress("i@i.com"));
    }
    @Test
    public void test_Domain_Invalid(){
        assertFalse(EmailClient.isValidAddress("i@i"));
    }

    @Test
    public void test_Password_Expiration_True(){
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("UsuarioValido").setDomain("!++*/+").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.now().plusDays(200)).build();
        assertTrue(emailAccountTest.verifyPasswordExpiration());
    }

    @Test
    public void test_Password_Expiration_False(){
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("UsuarioValido").setDomain("!++*/+").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.of(2018, 5, 1)).build();
        assertFalse(emailAccountTest.verifyPasswordExpiration());

    }
}