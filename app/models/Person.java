package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;

@Entity
public class Person extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    public String name;


    public static final Finder<Long, Person> find = new Finder<>(Person.class);

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}