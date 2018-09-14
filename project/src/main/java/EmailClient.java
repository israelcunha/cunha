import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class EmailClient implements EmailService {


    private Collection<EmailAccount> accounts;
    private EmailService emailService;


    public void setEmailService (EmailService emailService){
            this.emailService = emailService;
        }
        public boolean isValidAddress (String emailAddress){
            Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
            Matcher m = p.matcher(emailAddress);

            return m.find();
        }

        public boolean isValidEmail (Email email){
            return email.getCreationDate() != null && !email.getTo().isEmpty() && !email.getFrom().isEmpty();
        }

        public Collection<Email> emailList (EmailAccount account){
            if (!account.verifyPasswordExpiration() && account.getPassword().length() <= 6) {
                throw new RuntimeException();
            }
            return emailService.emailList(account);
        }

        public void sendEmail (Email email){
            if (!this.isValidEmail(email)) {
                throw new RuntimeException();
            }
            emailService.sendEmail(email);
        }

        public boolean createAccount (EmailAccount account){
            if (account.getUser() != null && account.getDomain() != null && account.getPassword().length() > 6) {
                account.setLastPasswordUpdate(LocalDate.now());
                accounts.add(account);
                return true;
            } else {
                return false;
            }
        }

   }

