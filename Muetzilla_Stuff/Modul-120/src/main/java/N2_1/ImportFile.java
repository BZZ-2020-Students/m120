package N2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;


public class ImportFile {


    static public ArrayList<String> readLinesFromFile(String path) {
        ArrayList<String> hobbys = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            Object[] string = stream.toArray();
            for (Object o : string) {
                String newString = (String) o;
                hobbys.add(newString.replace("\"", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return hobbys;
    }

}
