import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmailClientTest {

    EmailBuilder emailBuilder;
    EmailAccountBuilder emailAccountBuilder;
    EmailClient emailClient;

    String email_Valido = "i@i.com";
    String email_Invalido = "i@.x";
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
    public void test_Email_Valid() {
        this.to.add(email_Valido);
        this.bcc.add(email_Valido);
        this.cc.add(email_Valido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom("email_Valido")
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_Invalid() throws RuntimeException {
        this.to.add(null);
        this.bcc.add(null);
        this.cc.add(null);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(null)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage(null)
                .setSubject(null)
                .build();
        Assertions.assertThrows(RuntimeException.class, () -> { emailClient.isValidEmail(emailTest);
     });
    }

    @Test
    public void test_Email_Invalid_Without_CreationDate() {
        this.to.add(email_Invalido);
        this.bcc.add(email_Valido);
        this.cc.add(email_Valido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(email_Valido)
                .setCreationDate(null)
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertFalse(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_Invalid_With_TOInvalid() {
        this.to.add(email_Invalido);
        this.bcc.add(email_Valido);
        this.cc.add(email_Valido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(email_Valido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_Invalid_With_CCInvalid() {
        this.to.add(email_Valido);
        this.bcc.add(email_Valido);
        this.cc.add(email_Invalido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(email_Valido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_Invalid_With_BCC_Invalid() {
        this.to.add(email_Valido);
        this.bcc.add(email_Invalido);
        this.cc.add(email_Valido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(email_Valido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_EmailInvalid_WithFrom_Invalid() {
        this.to.add(email_Valido);
        this.bcc.add(email_Valido);
        this.cc.add(email_Valido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(email_Invalido)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage("message")
                .setSubject("subject")
                .build();
        assertTrue(emailClient.isValidEmail(emailTest));
    }

    @Test
    public void test_Email_List_With_PasswordValid() throws RuntimeException {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("me").setDomain("se").setPassword("9877778")
                .setLastPasswordUpdate(LocalDate.now()).build();
        assertThrows(RuntimeException.class, () -> {
            emailClient.emailList(emailAccountTest);
        });
    }

    @Test
    public void test_Email_List_With_PasswordInvalid() throws RuntimeException {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser(null).setDomain(null).setPassword("12")
                .setLastPasswordUpdate(LocalDate.of(2018,05,05 )).build();

        assertThrows(RuntimeException.class, () -> {emailClient.emailList(emailAccountTest);
    });
    }

    @Test
    public void test_SendEmail_With_EmailValid() throws RuntimeException {
        this.to.add(email_Valido);
        this.bcc.add(email_Valido);
        this.cc.add(email_Valido);
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(email_Valido)
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
    public void test_SendEmail_With_EmailInvalid() throws RuntimeException {
        Email emailTest = emailBuilder.setBcc(bcc)
                .setCc(cc)
                .setFrom(null)
                .setCreationDate(LocalDate.now())
                .setTo(to)
                .setMessage(null)
                .setSubject(null)
                .build();
        Assertions.assertThrows(RuntimeException.class, () -> {emailClient.sendEmail(emailTest);
        });

    }

    @Test
    public void test_Create_Account_Valid() {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser("s").setDomain("asc").setPassword("12bbb67")
                .setLastPasswordUpdate(LocalDate.now()).build();

        assertTrue(emailClient.createAccount(emailAccountTest));
    }

    @Test
    public void test_Create_Account_inValid() {
        EmailAccount emailAccountTest = emailAccountBuilder.setUser(null).setDomain(null).setPassword(null)
                .setLastPasswordUpdate(LocalDate.of(2016, 05, 05)).build();

        Assertions.assertFalse(emailClient.createAccount(emailAccountTest));
    }

    @Test
    public void test_SetEmailService() {
        Assertions.assertDoesNotThrow(() -> {
            emailClient.setEmailService(emailClient.getEmailService());
        });
    }
}