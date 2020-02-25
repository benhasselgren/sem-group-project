package com.napier.sem.classes;

/** Represents a countries language.
 * @author SEM Group Project
 */
public class CountryLanguage {
    /**
     * Instance variables.
     */
    private Country country;
    private String language;
    private boolean isOfficial;
    private double percentage;

    /**
     * Getters and setters.
     */
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Constructor.
     */
    public CountryLanguage()
    {}
}
