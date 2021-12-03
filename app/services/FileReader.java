package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    //private String regex = "[0-9,a-z,A-Z]+[.][0-9,a-z,A-Z]+([.]?[0-9,a-z,A-Z]*){0,}[=]";
    private String filePath;
    private ArrayList<String> file = new ArrayList<>();

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> readFile(){
        File f = new File(filePath);
        try {
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()){
                this.file.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return file;
    } public static ArrayList<String> staticReadFile(String filePath){
        File f = new File(filePath);
        ArrayList<String> file = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()){
                file.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return file;
    }
}
