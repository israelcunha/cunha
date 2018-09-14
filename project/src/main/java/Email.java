import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;

public class Email {
    private LocalDate creationDate;
    private String from ;
    private Collection <String> to;
    private Collection <String> cc;
    private Collection <String> bcc;
    private String subject;
    private String message;
    private String user;
    private String domain;
    private String password;
    private LocalDate lastPasswordUpdate;

    public Email() {
    }


    public Email(LocalDate creationDate, String from, Collection<String> to, Collection<String> cc, Collection<String> bcc,
                 String subject, String message, String user, String domain, String password, LocalDate lastPasswordUpdate) {

        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.message = message;
        this.user = user;
        this.domain = domain;
        this.password = password;
        this.lastPasswordUpdate = LocalDate.now();
    }

    public LocalDate getCreationDate() { return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    public String getFrom() {return from;}

    public void setFrom(String from) {this.from = from;}

    public Collection<String> getTo() {return to;}

    public void setTo(Collection<String> to) {this.to = to;}

    public Collection<String> getCc() {return cc;}

    public void setCc(Collection<String> cc) {this.cc = cc;}

    public Collection<String> getBcc() {return bcc;}

    public void setBcc(Collection<String> bcc) {this.bcc = bcc;}

    public String getSubject() {return subject;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message; }

    public String getUser(String user) {return user;}

    public void setUser(String user) { this.user = user;}

    public String getDomain() { return domain; }

    public void setDomain(String domain) {this.domain = domain;}

    public String getPassword() { return password; }

    public void setPassword(String password) {this.password = password;}

    public LocalDate getLastPasswordUpdate() {return lastPasswordUpdate;}

    public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {this.lastPasswordUpdate = lastPasswordUpdate;
    }
}