package services;

import models.myResult;

import java.io.IOException;
import java.util.ArrayList;

public class run {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        ArrayList<String> stringArrayList2 = new ArrayList<>();
        ArrayList<String> stringArrayList3 = new ArrayList<>();
        String regex = "[0-9,a-z,A-Z]+[.][0-9,a-z,A-Z]+([.]?[0-9,a-z,A-Z]*){0,}[=]";
        /*
        FileReader fr = new FileReader("data/lang/en.txt");

        System.out.println("Non-static file read");
        stringArrayList1 = fr.readFile();
        for (String s: stringArrayList1) {
            System.out.println(s);
        }


         */
        System.out.println("static read of file 1");

        stringArrayList2 = RegexParser.regex(FileReader.staticReadFile("data/lang/en.txt"),regex);
        for (String s: stringArrayList2) {
            System.out.println(s);
        }
        System.out.println("static read of file 2");
        stringArrayList3 = RegexParser.regex(FileReader.staticReadFile("data/lang/cs.txt"),regex);
        for (String s: stringArrayList3) {
            System.out.println(s);
        }
        System.out.println("static read of file 1");
        for (String s: stringArrayList2) {
            System.out.println(s);
        }

        myResult myResult = Comparator.compare(stringArrayList2,stringArrayList3);
        System.out.println(myResult.getArr1() + "\n" + myResult.getArr2());

        /*
        RegexParser parser1 = new RegexParser();
        RegexParser parser2 = new RegexParser();


        try {
            stringArrayList1 = parser1.parse("data/lang/messages.cs");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            stringArrayList2 = parser2.parse("data/lang/messages.en");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Arr1:");
        for (String s : stringArrayList1) {
            System.out.println(s);
        }


        System.out.println("Arr2:");
        for (String s : stringArrayList2) {
            System.out.println(s);
        }

        System.out.println("result:");
        myResult myResult = Comparator.compare(stringArrayList1,stringArrayList2);
        System.out.println("list1:");
        for (String s : myResult.getArr1()) {
            System.out.println(s);
        }

        System.out.println("list2:");
        for (String s : myResult.getArr2()) {
            System.out.println(s);
        }*/
    }
}
