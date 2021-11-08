package controllers;

import models.ComparableStrings;
import models.Pair;
import models.myResult;
import models.*;
import play.data.Form;
import play.mvc.*;

import services.Comparator;
import services.LogInCheck;
import services.SignUpCheck;
import views.html.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final AssetsFinder assetsFinder;

    private Map<String, String> data = new HashMap<>();
    private ArrayList<String> arr1 = new ArrayList<>();
    private ArrayList<String> arr2 = new ArrayList<>();


    @Inject play.data.FormFactory formFactory;

    @Inject
    public HomeController(AssetsFinder assetsFinder) {
        this.assetsFinder = assetsFinder;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(
            index.render(
                "Your new application is ready.",
                assetsFinder
            ));
    }

    public Result validated(){
        return ok(views.html.validated.render());
    }

    public Result test(String conf){
       // Form<User> userForm = formFactory.form(User.class);
        /*data.put("email","aaa");
        data.put("password", "bbb");
        System.out.println(data.get("email"));
        System.out.println(data.size());
*/
        //User user = userForm.bind(lang, attrs, data).get();
        return ok(views.html.test.render(conf));
    }
    public Result recieved(String conf, Http.Request request){
        //System.out.println(request.body().asFormUrlEncoded());
        Form<Pair> msgForm = formFactory.form(Pair.class).bindFromRequest(request);

        if (msgForm.hasErrors()){
            if(msgForm.error("email").isPresent())
                return badRequest(views.html.test.render(msgForm.error("email").get().message()));
            if(msgForm.error("password").isPresent())
                return badRequest(views.html.test.render("Password incorrect"));
            System.out.println("Error occured");
            return badRequest(views.html.test.render("Bad request"));
        }
        else {

            Pair p = msgForm.get();
            //System.out.println(p.getEmail() + " --- " + p.getPassword());
            return redirect("http://localhost:9000/validated");

        }
    }


    public Result goBack(){
        System.out.println("Comming to test page");



        return redirect("http://localhost:9000/test");
    }

    public Result signUpPage(){
        return ok(views.html.signUp.render());
    }
    public Result logInPage(){
        return ok(views.html.logIn.render());
    }

    /*public Result signUp(Http.Request request) {
        Form<PartialUserForm> form = formFactory.form(PartialUserForm.class, SignUpCheck.class).bindFromRequest(request);
        if (form.hasErrors())
            return badRequest(form.errors().toString());
        return ok(views.html.test.render("Signed in."));
    }*/

    public Result signUp(Http.Request request) {
        Form<User> form = formFactory.form(User.class, SignUpCheck.class).bindFromRequest(request);
        if (form.hasErrors())
            return badRequest(form.errors().toString());
        User user = form.get();
        Address address = new Address("aa","aa","aa");
        address.save();
        user.setAddress(address);
        //address.save();
        user.save();
        return redirect("logIn");
    }

    public Result logIn(Http.Request request){
        Form<User> form = formFactory.form(User.class, LogInCheck.class).bindFromRequest(request);
        if (form.hasErrors())
            return badRequest(form.errors().toString());
        User user = form.get();
        if (user == null)
            return badRequest("user is null");
        if (user.getPassword().equals(User.find.byId(user.getEmail()).getPassword()))
            return ok(views.html.test.render("Logged In."));
        else
            return badRequest("error");
    }

    public Result test0(String conf){
        ArrayList<String> empty = new ArrayList<>();
        return ok(views.html.test0.render("a", empty, empty));
    }

    public Result test0Post(String conf, Http.Request request){
/*
        // datasource
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUsername("test");
        dataSourceConfig.setPassword("123");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/localdb?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSourceConfig.setDriver("com.mysql.cj.jdbc.Driver");

        // configuration ...
        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(dataSourceConfig);

        Database database = DatabaseFactory.create(config);

        User user = new User("email","name","pass");
        database.save(user);
*/





        Form<ComparableStrings> msgForm = formFactory.form(ComparableStrings.class).bindFromRequest(request);
        if (msgForm.hasErrors())
            return badRequest("Error");
        ComparableStrings cs = msgForm.get();
/*
        Parser parser1 = new Parser(cs.getS1());
        arr1 = parser1.parse();
        Parser parser2 = new Parser(cs.getS2());
        arr2 = parser2.parse();

        Comparator comparator = new Comparator(arr1, arr2);
        myResult res = comparator.compare();

        return ok(views.html.test0.render("done",res.getArr1(),res.getArr2()));
    */
        return ok();

    }


}
