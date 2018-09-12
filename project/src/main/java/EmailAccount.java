import java.time.LocalDate;

public class EmailAccount {
    private String user;
    private String domain;
    private String password = "16/06/2018";
    private LocalDate lastPasswordUpdate = LocalDate.now();

    public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public boolean verifyPasswordExpiration(String password) {

        if ()

            return true;
             else
            return false;

        }
    }

