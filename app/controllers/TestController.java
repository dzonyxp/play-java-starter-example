package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

public class TestController extends Controller {
    private ArrayList<String> list = new ArrayList<>();
    public Result test0(String conf){
        list.add("aa");
        list.add("bb");
        list.add("cc");
        return ok(views.html.test0.render(conf, list));
    }
}
