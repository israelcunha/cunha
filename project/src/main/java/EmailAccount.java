import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAccount {
    private String user;
    private String domain;
    private String password;
    private LocalDate lastPasswordUpdate;


    public EmailAccount(){}

    public String getUser() {return user;}

    public String getDomain() {return domain;}

    public String getPassword() {return password;}

    public void setUser(String user) {
        this.user = user;
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

    public boolean verifyPasswordExpiration() {
        LocalDate dataAtual = LocalDate.now();
        int mes = this.lastPasswordUpdate.getMonthValue();
        int ano = this.lastPasswordUpdate.getYear();
        if (dataAtual.getYear() == ano && dataAtual.getMonthValue() - mes >= 3) {
            return false;
        }
        return true;
    }
}