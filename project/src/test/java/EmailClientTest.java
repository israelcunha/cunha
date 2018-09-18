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

    String emailValido = "i@i.com";
    String emailInvalido = "i@.x";
    private Collection<String> to;
    private Collection<String> cc;
    private Collection<String> bcc;


    @BeforeEach
    public void setUpTest() {
        this.emailBuilder = new EmailBuilder();
        this.emailAccountBuilder = new EmailAccountBuilder();
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
        assertTrue(emailClient.isValidEmail(emailTest));
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
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_Invalid_With_BCC_Invalid() {
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
        assertTrue(emailClient.isValidEmail(emailTest));
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
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_List_With_PasswordValid() throws RuntimeException {
        EmailAccount emailAccountTest =  emailAccountBuilder.setUser("me").setDomain("se").setPassword("9877778")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertThrows(RuntimeException.class,() -> {emailClient.emailList(emailAccountTest);
        });
    }

    @Test
    public void test_Email_List_With_PasswordInvalid() throws RuntimeException {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("name").setDomain("damain").setPassword("9877778")
                .setLastPasswordUpdate(LocalDate.now()).build();

        Assertions.assertThrows(RuntimeException.class, () -> {emailClient.emailList(emailAccountTest);
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

        Assertions.assertThrows(RuntimeException.class,() -> {
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

    @Test
    public void test_Create_Account_Valid() throws RuntimeException {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("en").setDomain("Um").setPassword("1234756")
                .setLastPasswordUpdate(LocalDate.now()).build();

        Assertions.assertThrows(RuntimeException.class, () -> {emailClient.createAccount(emailAccountTest);
        });
    }
}