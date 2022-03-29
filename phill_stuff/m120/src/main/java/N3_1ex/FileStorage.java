package N3_1ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileStorage {

    private static final String filepath="C:\\Users\\phill\\Desktop\\test";

    public static void main(String[] args){
        FileStorage storage = new FileStorage();

        ArrayList<String> a = new ArrayList<String>();

        storage.writeObjectToFile(a);

        a = (ArrayList<String>) storage.readObjectFromFile();


    }

    public void writeObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file on path: " + filepath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object readObjectFromFile() {
        Object ret = null;
        try{
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ret = objectIn.readObject();
            objectIn.close();
            System.out.println("The Object was succesfully read!");
            return ret;

        } catch (Exception ex) {
            System.out.println("No File was found on path: " + filepath);


        }finally {
            return ret;
        }
    }
}
