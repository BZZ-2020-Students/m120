import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileHandler<T extends CSVFileHandler.CSVSerializable<? extends T>> {
    private final char delimiter;

    public interface CSVSerializable<T> {
        String toCSV(char delimiter);
        String getCSVHeader(char delimiter);
        T fromCSV(String[] csv);
    }

    public CSVFileHandler(char delimiter){
        this.delimiter = delimiter;
    }

    public List<T> read(String fileName, T object) {
        var file = new File(fileName);
        System.out.println("Reading from file: " + file.getAbsolutePath());

        try {
            var scanner = new Scanner(file);
            scanner.nextLine();

            ArrayList<T> objs = new ArrayList<>();
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                System.out.println("Read Line: " + line);
                var values = line.split(String.valueOf(delimiter));
                var newObj = object.fromCSV(values);
                objs.add(newObj);
            }
            return objs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void write(String fileName, List<T> objects) {
        var file = new File(fileName);
        System.out.println("Writing to file: " + file.getAbsolutePath());
        try {
            var writer = new FileWriter(file);

            writer.append(objects.get(0).getCSVHeader(delimiter)).append(System.lineSeparator());

            for (var obj : objects) {
                var values = obj.toCSV(delimiter);
                writer.append(values).append(System.lineSeparator());
            }

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    record Person(String name, int age) implements CSVSerializable<Person> {

        @Override
        public String toCSV(char delimiter) {
            return name + delimiter + age;
        }

        @Override
        public String getCSVHeader(char delimiter) {
            return "Name" + delimiter + "Age";
        }

        @Override
        public Person fromCSV(String[] csv) {
            return new Person(csv[0], Integer.parseInt(csv[1]));
        }
    }

    public static void main(String[] args) {
        var person = new Person("John", 30);
        var csvFileHandler = new CSVFileHandler<Person>(',');
        csvFileHandler.write("person.csv", List.of(person));

        var people = csvFileHandler.read("person.csv", person);
        System.out.println(people);
    }
}