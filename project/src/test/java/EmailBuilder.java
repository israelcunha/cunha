import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;


public class EmailBuilder {
    private LocalDate creationDate = LocalDate.now();
    private String from ;
    private Collection<String> to;
    private Collection <String> cc;
    private Collection <String> bcc;
    private String subject;
    private String message;
    private String user;
    private String domain;
    private String password;
    private LocalDate lastPasswordUpdate;


    public EmailBuilder setUser(String user) {
        this.user = user;
        return this;
    }
    public String getUser() {
        return user;
          }

    public String getDomain() {
        return domain;
          }

    public String getPassword() {
        return password;
         }

    public LocalDate getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPassword(String password) {
        this.password = password;
          }

    public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;

    }

    public EmailBuilder setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public EmailBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public EmailBuilder setTo(Collection<String> to) {
        this.to = to;
        return this;
    }

    public EmailBuilder setCc(Collection<String> cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder setBcc(Collection<String> bcc) {
        this.bcc = bcc;
        return this;
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public Email build(){
        Email email = new Email();
        email.setCreationDate (this.creationDate);
        email.setFrom(this.from);
        email.setTo(this.to);
        email.setCc(this.cc);
        email.setBcc(this.bcc);
        email.setSubject(this.subject);
        email.setMessage(this.message);
        email.setDomain(this.domain);
        email.setPassword(this.password);
        email.setUser(this.user);
        email.setLastPasswordUpdate(this.lastPasswordUpdate);

        return email;
    }
}