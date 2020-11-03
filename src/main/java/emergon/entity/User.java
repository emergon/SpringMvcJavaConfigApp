package emergon.entity;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;//Bean Validation API
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
    @NotEmpty(message = "{NotEmpty.user.username}")
    private String username;
    @NotNull
    @NotEmpty(message = "{NotEmpty.user.password}")
    @Size(min = 3, message = "{Size.user.password}")
    private String password;
    @PastOrPresent(message = "{PastOrPresent.user.dob}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//This converts mm-dd-yyyy to yyyy-MM-dd
    private LocalDate dob;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    
}
