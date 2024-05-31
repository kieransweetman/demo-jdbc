package fr.diginamic.census.entities;

public class Department {
    private int id;
    private String code;

    public Department() {
        super();
    }

    public Department(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", code=" + code + "]";
    }
}
