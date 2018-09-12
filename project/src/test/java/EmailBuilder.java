import java.time.Instant;
import java.util.Collection;


public class EmailBuilder {
    private Instant creationDate = Instant.now();
    private String from = "date" ;
    private Collection<String> to;
    private Collection <String> cc;
    private Collection <String> bcc;
    private String subject  = "sub";
    private String message = "Mensagem";


    public EmailBuilder setCreationDate(Instant creationDate) {
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
        Email emial = new Email();
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