package com.napier.sem.classes;

/** Represents a country.
 * @author SEM Group Project
 */
public class Country {
    // ------------------------------------- Instance variables -------------------------------------
    private String code;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private int indepYear;
    private int population;
    private double lifeExpectancy;
    private double gnp;
    private double gnpold;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private City capitalCity;

    // ------------------------------------- Getters/Setters -------------------------------------
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public double getGnpold() {
        return gnpold;
    }

    public void setGnpold(double gnpold) {
        this.gnpold = gnpold;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public City getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(City capitalCity) {
        this.capitalCity = capitalCity;
    }

    /**
     * Constructor.
     * Returns an empty object
     */
    public Country()
    {}

    /**
     * Constructor.
     * Returns an object with every field assigned to apart from city
     */
    public Country(String code, String name, String continent, String region, double surfaceArea, int indepYear, int population, double lifeExpectancy, double gnp, double gnpold, String localName, String governmentForm, String headOfState, City capitalCity) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpold = gnpold;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capitalCity = capitalCity;
    }

    // ------------------------------------- Methods -------------------------------------

    /**
     * Creates a string from country.
     * @return A string
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + this.code + '\'' +
                ", name='" + this.name + '\'' +
                ", continent='" + this.continent + '\'' +
                ", region='" + this.region + '\'' +
                ", surfaceArea=" + this.surfaceArea +
                ", indepYear=" + this.indepYear +
                ", population=" + this.population +
                ", lifeExpectancy=" + this.lifeExpectancy +
                ", gnp=" + this.gnp +
                ", gnpold=" + this.gnpold +
                ", localName='" + this.localName + '\'' +
                ", governmentForm='" + this.governmentForm + '\'' +
                ", headOfState='" + this.headOfState + '\'' +
                ", capitalCity='" + this.capitalCity.getName() + '\'' +
                '}';
    }

    /**
     * Creates a string for a country report.
     * @return A string
     */
    public String toCountryReportString() {
        return String.format("Code: %s, Name: %s, Continent: %s, Region: %s, Population: %d, Capital: %s", this.code, this.name, this.continent, this.region, this.population, this.capitalCity.getName());
    }
}
