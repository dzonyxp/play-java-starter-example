package models;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.datasource.DataSourceFactory;
import org.junit.Before;
import org.junit.Test;
import play.db.Databases;
import play.test.WithApplication;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class ModelsTest  extends WithApplication {

    @Test
    public void createAndRetrieveUser(){
        DB.getDefault();
        //DB.save(new User("bob@gmail.com","Bob","Secret"));
        User bob = User.find.byId("bob@gmail.com");
        assertNotNull(bob);
        assertEquals("Bob", bob.getName());
    }

}
