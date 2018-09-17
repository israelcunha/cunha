import java.time.LocalDate;
import java.util.Collection;

public class EmailAccountBuilder {

        private String user;
        private String domain;
        private String password;
        private LocalDate lastPasswordUpdate;


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

    public EmailAccountBuilder setUser(String user) {
        this.user = user;
        return this;
    }

    public EmailAccountBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public EmailAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public EmailAccountBuilder setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
        return this;

    }


    public EmailAccount build() {
        EmailAccount email = new EmailAccount();
        email.setDomain(this.domain);
        email.setPassword(this.password);
        email.setUser(this.user);
        email.setLastPasswordUpdate(this.lastPasswordUpdate);

        return email;
    }
}