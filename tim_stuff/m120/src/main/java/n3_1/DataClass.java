package n3_1;

import java.io.Serializable;

public class DataClass implements Serializable, Comparable {
    private String name;

    public DataClass() {
    }

    public DataClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((DataClass) o).getName());
    }
}
