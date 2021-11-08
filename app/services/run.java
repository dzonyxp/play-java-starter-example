package services;

import models.myResult;

import java.io.IOException;
import java.util.ArrayList;

public class run {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        ArrayList<String> stringArrayList2 = new ArrayList<>();

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


        /*System.out.println("Arr1:");
        for (String s : stringArrayList1) {
            System.out.println(s);
        }


        System.out.println("Arr2:");
        for (String s : stringArrayList2) {
            System.out.println(s);
        }*/

        System.out.println("result:");
        myResult myResult = Comparator.compare(stringArrayList1,stringArrayList2);
        System.out.println("list1:");
        for (String s : myResult.getArr1()) {
            System.out.println(s);
        }

        System.out.println("list2:");
        for (String s : myResult.getArr2()) {
            System.out.println(s);
        }
    }
}
