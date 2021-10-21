package models;

import java.util.*;
import javax.persistence.*;
/*
import io.ebean.*;*/
import play.data.format.*;

import play.data.validation.Constraints;
import play.data.validation.ValidationError;

@Constraints.Validate
public class Pair implements Constraints.Validatable<ValidationError>/* extends Model*/{
    @Constraints.Required(message = "Email required") private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public ValidationError validate() {
        if (email.equals("a")) {
            System.out.println(email + "- email Validator call");
            return new ValidationError("email", "Invalid");
        }
        if (password.equals("a")){
            System.out.println(password + "- password Validator call");
            return new ValidationError("password", "Invalid");
        }
        else {
            return null;

        }
    }
}
