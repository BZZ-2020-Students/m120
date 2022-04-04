package N2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Imports the *.dat files into the program
 *
 * @Author Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */
public class ImportFile {

    /**
     * Default constructor
     */
    public ImportFile() {

    }

    /**
     * Reads the lines from the file
     *
     * @param path to the location of the file
     * @return an array of Ints which can then be sorted
     */
    public int[] readLinesFromFile(String path) {
        ArrayList<Integer> numberLinesAsArrayList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            Object[] string = stream.toArray();
            for (Object o : string) {
                if (checkStringValidInt((String) o)) {
                    numberLinesAsArrayList.add(Integer.parseInt((String) o));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] fileValuesAsIntArray = new int[numberLinesAsArrayList.size()];

        for (int i = 0; i < fileValuesAsIntArray.length; i++) {
            fileValuesAsIntArray[i] = numberLinesAsArrayList.get(i);
        }

        return fileValuesAsIntArray;
    }

    /**
     * Checks if the String is a valid Int
     *
     * @param stringToTest the String to check
     * @return if the String is a valid Int or not
     */
    public boolean checkStringValidInt(String stringToTest) {
        try {
            Integer.parseInt(stringToTest);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}
