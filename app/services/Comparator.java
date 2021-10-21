package services;

import models.Resoult;

import java.util.ArrayList;

public class Comparator {
    private ArrayList<String>arr1;
    private ArrayList<String>arr2;
    private Resoult resoult = new Resoult();
    private int count;

    public Comparator(ArrayList<String> array1, ArrayList<String> array2) {
        this.arr1 = array1;
        this.arr2 = array2;
    }

    public Resoult compare(){
        /*TODO najst kazdy prvok prveho pola v druhom poli, v pripade zhody
            vymazat prvok z oboch poli. V pripade ze sa prvok nenachadza v druhom
            poli skacem na dalsi prvok. Na zaver len kontrola ci su polia prazdne
            (obe polia prazdne = polia boli identicke
            pokial ostal nejaky prvok v poli a nebol vymazany => bol v poli naviac)
        */
        //for (int i = 0; i<arr1.size(); i++)
            //System.out.println(arr1.get(i));
        this.count = 0;
        this.resoult.setArr1(arr1);
        this.resoult.setArr2(arr2);
        int sizeOfArray1 = arr1.size();
        for (int i = 0; i<sizeOfArray1; i++){
            if (arr2.contains(arr1.get(count))){
                arr2.remove(arr2.indexOf(arr1.get(count)));
                arr1.remove(count);
            }
            else{
                count++;
            }

        }
        return this.resoult;
        //System.out.println("Compare call");
    }
}
