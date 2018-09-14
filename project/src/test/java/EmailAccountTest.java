
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailAccountTest {

    EmailBuilder emailBuilder;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setUpTest() {

        this.emailBuilder = new EmailBuilder();
    }

    @Test
    public void testUserValid(){
        EmailClient emailClientTest = emailBuilder.setUser("UsuarioValido").setDomain("UserDamain1").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertTrue(emailClientTest.isValidAddress(emailBuilder.getUser()));
    }

    @Test
    public void testUserInvalid(){
        EmailClient emailClientTest = emailBuilder.setUser("User*-*---").setDomain("UserDamain1").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertFalse(emailClientTest.isValidAddress(emailBuilder.getUser()));
    }

    @Test
    public void testDomainValid(){
        EmailClient emailClientTest = emailBuilder.setUser("UsuarioValido").setDomain("DominionValido").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertTrue(emailClientTest.isValidAddress(emailBuilder.getUser()));
    }

    @Test
    public void testDomainInvalid(){
        EmailClient emailClientTest = emailBuilder.setUser("UsuarioValido").setDomain("!++*/+").setPassword("123456")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertFalse(emailClientTest.isValidAddress(emailBuilder.getUser()));
    }

    @Test
    public void testPasswordExpirationTrue(){
        EmailAccount emailAccountTest = emailBuilder.setUser("UsuarioValido").setDomain("!++*/+").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.now().plusDays(200)).build();
        assertTrue(emailAccountTest.verifyPasswordExpiration());

    }

    @Test
    public void testPasswordExpirationFalse(){
        EmailAccount emailAccountTest = emailBuilder.setUser("UsuarioValido").setDomain("!++*/+").setPassword("987654")
                .setLastPasswordUpdate(LocalDate.now().plusDays(98)).build();
        assertFalse(emailAccountTest.verifyPasswordExpiration());

    }
}
}