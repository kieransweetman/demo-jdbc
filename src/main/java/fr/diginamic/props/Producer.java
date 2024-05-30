package fr.diginamic.props;

public class Producer {
    private int id;
    private String name;
    private String item;

    public Producer(int id, String name, String item) {
        super();
        this.id = id;
        this.name = name;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Producer [id=" + id + ", name=" + name + ", item=" + item + "]";
    }
}
