package models;

import javax.persistence.*;
import io.ebean.*;
import play.data.validation.*;

@Entity
public class Person extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;



    public static final Finder<Long, Person> find = new Finder<>(Person.class);
}