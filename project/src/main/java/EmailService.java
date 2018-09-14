import java.util.Collection;

public interface EmailService {

    void sendEmail(Email email);

    Collection<Email> emailList(EmailAccount account);

}