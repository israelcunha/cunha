import java.time.LocalDate;

public class EmailAccount {
    private String user = "user";
    private String domain = "ffm";
    private String password = "jose";
    private LocalDate lastPasswordUpdate = LocalDate.now();

    public String getUser() {
        return user;
    }

    public String getDomain() {
        return domain;
    }

    public String getPassword() {
        return password;
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

    public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public boolean verifyPasswordExpiration() {
        LocalDate dataAtual = LocalDate.now();
        int mes = this.lastPasswordUpdate.getMonthValue();
        int ano = this.lastPasswordUpdate.getYear();
        if (dataAtual.getYear() == ano && dataAtual.getMonthValue() - mes >= 3) {
            return false;
        } else if (dataAtual.getMonthValue() == (mes + 3) - 12) {
            return false;
        }
        return true;

    }
}
