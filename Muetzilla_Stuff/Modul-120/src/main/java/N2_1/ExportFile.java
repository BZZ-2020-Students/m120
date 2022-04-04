package N2_1;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Exports the data gathered form the algorithm to a *.csv file
 *
 * @Author Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */

public class ExportFile {
    private String filemame;
    private ArrayList<String[]> sortedValues;

    /**
     * @param filename      of the *.csv file
     * @param sortingValues the ArrayList of all String arrays with the valuesay<s
     */
    public ExportFile(String filename, ArrayList<String[]> sortingValues) {
        this.filemame = filename;
        this.sortedValues = sortingValues;
    }

    /**
     * Creates a *.csv file and fills the values into the file.
     */
    public void writeInCsvFile() {
        File file = new File(filemame);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"Sortingalgorithm", "Iterations done", "Comparisons done", "Time needed in milliseconds"};
            writer.writeNext(header);
            for (String[] s : sortedValues) {
                writer.writeNext(s);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the filename
     */
    public String getFilemame() {
        return filemame;
    }

    /**
     * @param filemame for the new csv file
     */
    public void setFilemame(String filemame) {
        this.filemame = filemame;
    }

    /**
     * @return the sorted values which will be written to the file
     */
    public ArrayList<String[]> getSortedValues() {
        return sortedValues;
    }

    /**
     * @param sortedValues which will be written to the file
     */
    public void setSortedValues(ArrayList<String[]> sortedValues) {
        this.sortedValues = sortedValues;
    }

}