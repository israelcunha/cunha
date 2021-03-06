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

    public Email() {
    }

    public LocalDate getCreationDate() { return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    public String getFrom() {return from;}

    public void setFrom(String from) {this.from = from;}

    public Collection<String> getTo() {return to;}

    public void setTo(Collection<String> to) {this.to = to;}

    public void setCc(Collection<String> cc) {this.cc = cc;}

    public void setBcc(Collection<String> bcc) {this.bcc = bcc;}

    public void setSubject(String subject) {this.subject = subject;}

    public void setMessage(String message) {this.message = message; }

   }
