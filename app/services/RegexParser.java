package services;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexParser{

    private  ArrayList<String> list = new ArrayList<>();

    public RegexParser() {
    }

    /*public void clear(){
        this.list.clear();
    }*/
    public static CharSequence fromFile(String filename) throws IOException {

        FileInputStream fis = new FileInputStream(filename);
        FileChannel fc = fis.getChannel();

        // Create a read-only CharBuffer on the file
        ByteBuffer bbuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc.size());
        CharBuffer cbuf = Charset.forName("8859_1").newDecoder().decode(bbuf);
        fis.close();
        fc.close();
        return cbuf;

    }
    public  ArrayList<String> parse(String path) throws IOException {
        // Create matcher on file
        Pattern pattern = Pattern.compile("[0-9,a-z,A-Z]+[.][0-9,a-z,A-Z]+([.]?[0-9,a-z,A-Z]*){0,}[=]");
        Matcher matcher = pattern.matcher(fromFile(path));

        // Find all matches
        while (matcher.find()) {
            // Get the matching string
            String match = matcher.group();
            this.list.add(match);
            //System.out.println(match);
        }

        return this.list;
    }

    public static ArrayList<String> regex(ArrayList<String> list, String regex) {

        ArrayList<String> matches = new ArrayList<>();

        for (String s: list) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);

            // Find all matches
            while (matcher.find()) {
                // Get the matching string
                String match = matcher.group();
                matches.add(match);
                //System.out.println(match);
            }
        }
        return matches;
    }

}

