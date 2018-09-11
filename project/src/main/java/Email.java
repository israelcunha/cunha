import java.util.Collection;

public class Email {

   public String from;
   Collection<String> to;
   Collection<String> cc;
   Collection<String> bcc;
   public String subject;
   public String message;


   public Email(){

    }

    public String getFrom() {
        return from;
    }

    public Collection<String> getTo() {
        return to;
    }

    public Collection<String> getCc() {
        return cc;
    }

    public Collection<String> getBcc() {
        return bcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(Collection<String> to) {
        this.to = to;
    }

    public void setCc(Collection<String> cc) {
        this.cc = cc;
    }

    public void setBcc(Collection<String> bcc) {
        this.bcc = bcc;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}