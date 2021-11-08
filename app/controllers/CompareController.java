package controllers;

import play.libs.Files.TemporaryFile;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;

public class CompareController extends Controller {

    public Result compare(Http.Request request){
        if (request.method() == "POST"){
            Http.MultipartFormData<TemporaryFile> body = request.body().asMultipartFormData();
            Http.MultipartFormData.FilePart<TemporaryFile> file1 = body.getFile("file1");
            Http.MultipartFormData.FilePart<TemporaryFile> file2 = body.getFile("file2");
            if(file1 != null && file2 != null){
                String file = file1.getKey();
                TemporaryFile file1_1 = file1.getRef();
                TemporaryFile file2_2 = file2.getRef();
                System.out.println(file);
                System.out.println(file1);
                System.out.println(file2_2);
                return ok();
            }
            return badRequest();
        }
        else
            return ok(views.html.compare.render());
    }


}
