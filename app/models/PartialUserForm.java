package models;

import play.data.validation.Constraints;
import play.data.validation.ValidationError;
import services.LogInCheck;
import services.SignUpCheck;

import javax.validation.groups.Default;

@Constraints.Validate(groups = {SignUpCheck.class})
public class PartialUserForm implements Constraints.Validatable<ValidationError> {
    @Constraints.Required(groups = {SignUpCheck.class, Default.class, LogInCheck.class})
    @Constraints.Email(groups = {Default.class, SignUpCheck.class})
    private String email;


    private String name;

    @Constraints.Required(groups = {SignUpCheck.class, LogInCheck.class}, message = "Password required.")
    private String password;
    @Constraints.Required(groups = {SignUpCheck.class})
    private String repeatPassword;

    public PartialUserForm() {

    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public PartialUserForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public ValidationError validate() {
        if (!(password.equals(repeatPassword)))
            return new ValidationError("repeatPassword", "Password do not match!");
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
