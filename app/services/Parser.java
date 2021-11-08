package services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static String string;

    public static ArrayList<String> parse(){
    String str[] = string.split(" ");
    ArrayList<String> strList = new ArrayList<String>(Arrays.asList(str));
    return strList;

    }
}
