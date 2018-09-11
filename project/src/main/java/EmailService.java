import java.util.Collection;

public interface EmailService {

    public boolean sendEmail(Email email);
    public Collection<Email> emailList(EmailAccount account);

}
