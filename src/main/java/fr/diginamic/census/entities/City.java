package fr.diginamic.census.entities;

public class City {

    private int id;
    private String name;
    private int population;
    private int departmentId;
    private int regionId;

    public City(int id, String name, int population, int departmentId, int regionId) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.departmentId = departmentId;
        this.regionId = regionId;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

}
