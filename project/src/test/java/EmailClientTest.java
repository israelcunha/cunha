import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmailClientTest {

    EmailBuilder emailBuilder;
    EmailAccountBuilder emailAccountBuilder;
    EmailClient emailClient;

    private Collection<String> to;
    private Collection<String> cc;
    private Collection<String> bcc;
    String emailValido = "i@i.com";
    String emailInvalido = "i@.x";


    @BeforeEach
    public void setUpTest() {
        this.emailBuilder = new EmailBuilder();
        this.emailClient = new EmailClient();
        this.to = new ArrayList<String>();
        this.cc = new ArrayList<String>();
        this.bcc = new ArrayList<String>();
    }

    @Test
    public void testEmailValid() {
        this.to.add(emailValido);
        this.bcc.add(emailValido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void testEmailInvalidWithoutCreationDate() {
        this.to.add(emailInvalido);
        this.bcc.add(emailValido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(null)
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertFalse(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void testEmailInvalidWithTOInvalid() {
        this.to.add(emailInvalido);
        this.bcc.add(emailValido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertFalse(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void testEmailInvalidWithCCInvalid() {
        this.to.add(emailValido);
        this.bcc.add(emailValido);
        this.cc.add(emailInvalido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertFalse(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void testEmailInvalidWithBCCInvalid() {
        this.to.add(emailValido);
        this.bcc.add(emailInvalido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertFalse(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void testEmailInvalidWithFromInvalid() {
        this.to.add(emailValido);
        this.bcc.add(emailValido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailInvalido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertFalse(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void testEmailListWithPasswordValid() throws RuntimeException {
        EmailAccount emailClientTest = emailAccountBuilder.setUser("UserName").setDomain("UserDamain").setPassword("988654")
                .setLastPasswordUpdate(LocalDate.now()).build();

        Assertions.assertDoesNotThrow(() -> {
            emailClient.emailList(emailClientTest);
        });
    }

    @Test
    public void testEmailListWithPasswordInvalid() throws RuntimeException {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("UserName").setDomain("UserDamain").setPassword("988654")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertThrows(RuntimeException.class, () -> {
            emailClient.emailList(emailAccountTest);
        });
    }

    @Test
    public void testSendEmailWithEmailValid() throws RuntimeException {
        this.to.add(emailValido);
        this.bcc.add(emailValido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();

        Assertions.assertDoesNotThrow(() -> {
            emailClient.sendEmail(emailTest);
        });
    }

    @Test
    public void testSendEmailWithEmailInvalid() throws RuntimeException {
        this.to.add(emailInvalido);
        this.bcc.add(emailValido);
        this.cc.add(emailValido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(emailValido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            emailClient.sendEmail(emailTest);
        });

    }

    @Test (Exepected = EmailAccount.class)
    public void test_Create_Account_Valid() {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("85").setDomain("UserDamain1").setPassword("123456")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertTrue(emailClient.createAccount(emailAccountTest));
    }
}