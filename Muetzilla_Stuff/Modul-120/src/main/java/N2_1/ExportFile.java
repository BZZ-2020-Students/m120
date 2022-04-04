package N2_1;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportFile {
    private String filemame;
    private ArrayList<String> hobbys;


    public ExportFile(String filename, ArrayList<String> sortingValues) {
        this.filemame = filename;
        this.hobbys = sortingValues;
    }


    public void writeInCsvFile() {
        File file = new File(filemame);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            for (String s : hobbys) {
                writer.writeNext(new String[]{s});
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getFilemame() {
        return filemame;
    }

    public void setFilemame(String filemame) {
        this.filemame = filemame;
    }


    public ArrayList<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(ArrayList<String> hobbys) {
        this.hobbys = hobbys;
    }

}