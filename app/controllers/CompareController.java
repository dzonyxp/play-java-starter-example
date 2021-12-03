package controllers;

import models.myResult;
import play.libs.Files.TemporaryFile;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.Comparator;
import services.FileReader;
import services.RegexParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareController extends Controller {

    private String regex = "[0-9,a-z,A-Z]+[.][0-9,a-z,A-Z]+([.]?[0-9,a-z,A-Z]*){0,}[=]";

    public Result compare(Http.Request request){
        if (request.method() == "POST"){


            Http.MultipartFormData<TemporaryFile> body = request.body().asMultipartFormData();
            Http.MultipartFormData.FilePart<TemporaryFile> file1 = body.getFile("file1");
            Http.MultipartFormData.FilePart<TemporaryFile> file2 = body.getFile("file2");
            if(file1 != null && file2 != null){


                TemporaryFile file1_1 = file1.getRef();
                TemporaryFile file2_2 = file2.getRef();


                file1_1.copyTo(Paths.get("data/lang/file1.txt"), true);
                file2_2.copyTo(Paths.get("data/lang/file2.txt"), true);

                String fileName1 = file1.getFilename();
                String fileName2 = file2.getFilename();

                ArrayList<String> stringArrayList1 = new ArrayList<>();
                ArrayList<String> stringArrayList2 = new ArrayList<>();


                stringArrayList1 = RegexParser.regex(FileReader.staticReadFile("data/lang/file1.txt"),regex);
                stringArrayList2 = RegexParser.regex(FileReader.staticReadFile("data/lang/file2.txt"),regex);


                myResult myResult = Comparator.compare(stringArrayList1,stringArrayList2);

                /*
                RegexParser parser1 = new RegexParser();
                RegexParser parser2 = new RegexParser();


                try {
                    stringArrayList1 = parser1.parse("data/lang/file1.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
                    stringArrayList2 = parser2.parse("data/lang/file2.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }*/



                return ok(views.html.comparisonDone.render( myResult.getArr1(),myResult.getArr2(),fileName1,fileName2));
            }
            return badRequest();

        }
        else
            return ok(views.html.compare.render());
    }


}
