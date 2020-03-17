package com.napier.sem.classes;

/** Represents a city.
 * @author SEM Group Project
 */
public class City {
    // ------------------------------------- Instance variables -------------------------------------
    private int id;
    private String name;
    private Country country;
    private String district;
    private int population;

    // ------------------------------------- Getters/Setters -------------------------------------
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Constructor.
     * returns an empty object
     */
    public City()
    {}

    /**
     * Constructor.
     * returns a city object with every field assigned to apart from country
     */
    public City(int id, String name, String district, int population) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.population = population;
    }

    // ------------------------------------- Methods -------------------------------------

}
