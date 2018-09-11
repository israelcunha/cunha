import java.util.Collection;

public class EmailClient {

    public EmailService emailService;
    public Collection <EmailAccount> accounts;

       public EmailClient(){

    }

    public Collection<EmailAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<EmailAccount> accounts) {
        this.accounts = accounts;
    }

    public void setEmailService(EmailService emailService){

    }

    public boolean isValidEmail(Email email){
            return true;
    }

    public Collection<Email> emailList(EmailAccount account){
            return null;
    }

    public Email sendEmail(Email email){
            return email;
    }

    public boolean createAccount(EmailAccount account){
            return true;
    }
}
