import java.time.Instant;

public class EmialBuilder {
    private Instant creationDate = Instant.now();
    private String from = "date" ;
    private Collection <String> to;
    private Collection <String> cc;
    private Collection <String> bcc;
    private String subject "sub";
    private String message "Mensagem";

     public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setFrom(String from) {
        this.from = from;
        return this;
    }

    public void setTo(Collection<String> to) {
        this.to = to;
        return this;
    }

    public void setCc(Collection<String> cc) {
        this.cc = cc;
        return this;
    }

    public void setBcc(Collection<String> bcc) {
        this.bcc = bcc;
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
        return this;
    }

    public Email build(){
        Email emial = new Person();
        emial.setCreationDate (this.creationDate);
        emial.setFrom(this.from);
        emial.setTo(this.to);
        emial.setCc(this.cc);
        emial.setBcc(this.bcc);
        emial.setSubject(this.subject);
        emial.setMessage(this.message);
        return emial;
    }
}