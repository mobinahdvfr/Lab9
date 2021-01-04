package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * handling the files
 * @author Mobina Hadavifar
 * @version 1.0
 */
public class FileUtils {

    private static final String NOTES_PATH = "./notes/";
    private static final String NOTES_BIN_PATH = "./notesBin/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor

    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
        isSuccessful = new File(NOTES_BIN_PATH).mkdirs();
        System.out.println("Creating " + NOTES_BIN_PATH + " directory is successful: " + isSuccessful);
    }

    /**
     * @return array of files in the special path
     */
//    public static File[] getFilesInDirectory() {
//        return new File(NOTES_PATH).listFiles();
//    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_BIN_PATH).listFiles();
    }


    /**
     * reads the given file
     * @param file the file we want to read the note from
     * @return content of the note
     */
//    public static String fileReader(File file) {
//        //TODO: Phase1: read content from file
//        try (FileReader fr = new FileReader(file)){
//            BufferedReader br = new BufferedReader(fr);
//            String content = "";
//            int i;
//            while (true){
//                i = br.read();
//                if (i == -1)
//                    break;
//                content = content + (char)i;
//            }
//            return content;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    //TODO: Phase1: define method here for reading file with InputStream
    public static String fileReader (File file) {
        try (FileInputStream fi = new FileInputStream(file)){
            ObjectInputStream oi = new ObjectInputStream(fi);

            Note note = (Note) oi.readObject();
            System.out.println(note);
            return note.getContent();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }




    /**
     * writes a string to a file
     * @param content content of the note
     */
//    public static void fileWriter(String content) {
//        //TODO: write content on file
//        String fileName = getProperFileName(content);
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(NOTES_PATH + fileName + ".txt"))) ){
//            bw.write(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //TODO: Phase1: define method here for writing file with OutputStream
    public static void fileWriter (String content){
        String fileName = getProperFileName(content);
        try (FileOutputStream fw = new FileOutputStream(new File(NOTES_BIN_PATH + fileName + ".bin"))){
            ObjectOutputStream os = new ObjectOutputStream(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Note note = new Note(fileName, content,sdf.format(new Date()));
            os.writeObject(note);
            System.out.println(note);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //TODO: Phase2: proper methods for handling serialization



    /**
     * makes a proper name for a note file
     * @param content of the note
     * @return name of the file
     */
    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
