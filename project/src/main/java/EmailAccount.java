import java.util.Date;

public class EmailAccount {

   public String user;
   private String domain;
   public String password;
   public Date lastPasswordUpdate;


    public EmailAccount() {

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

    public Date getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyPasswordExpiration(){
        return true;

    }
    public void setLastPasswordUpdate(Date lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }
}