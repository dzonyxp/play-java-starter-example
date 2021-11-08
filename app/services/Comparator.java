package services;

import models.myResult;

import java.util.ArrayList;

public class Comparator {
    private static final myResult myResult = new myResult();


    public static myResult compare(ArrayList<String> array1, ArrayList<String> array2){

        //for (int i = 0; i<arr1.size(); i++)
            //System.out.println(arr1.get(i));
        int count = 0;
        myResult.setArr1(array1);
        myResult.setArr2(array2);
        int sizeOfArray1 = array1.size();
        for (int i = 0; i<sizeOfArray1; i++){
            if (array2.contains(array1.get(count))){
                array2.remove(array2.indexOf(array1.get(count)));
                array1.remove(count);
            }
            else{
                count++;
            }

        }
        return myResult;
        //System.out.println("Compare call");
    }
}
