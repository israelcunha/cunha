import java.util.Collection;

public class EmailClient implements EmailService{



    public boolean isValidAddress(String emailAddress){
        throw new UnsupportedOperationException();
    }

    public boolean isValidEmail(Email email){
        throw new UnsupportedOperationException();
    }

    public Collection<Email> emailList(EmailAccount account){
        throw new UnsupportedOperationException();
    }

    public boolean sendEmail(Email email){
        throw new UnsupportedOperationException();
    }

    public boolean createAccount(EmailAccount account){
        throw new UnsupportedOperationException();
    }
}