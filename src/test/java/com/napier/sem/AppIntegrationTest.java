package com.napier.sem;

import com.napier.sem.classes.City;
import com.napier.sem.classes.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    // ------------------------------------- Initialise -------------------------------------
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    // ------------------------------------- Test testGetCountry() -------------------------------------
    @Test
    void testGetCountry()
    {
        Country country = app.getCountry("Argentina");
        assertEquals(country.getCode(), "ARG");
        assertEquals(country.getName(), "Argentina");
        assertEquals(country.getContinent(), "South America");
        assertEquals(country.getRegion(), "South America");
        assertEquals(country.getSurfaceArea(), 2780400.00);
        assertEquals(country.getIndepYear(), 1816);
        assertEquals(country.getPopulation(), 37032000);
        assertEquals(country.getLifeExpectancy(), 75.1);
        assertEquals(country.getLifeExpectancy(), 75.1);
        assertEquals(country.getGnp(), 340238.00);
        assertEquals(country.getGnpold(), 323310.00);
        assertEquals(country.getLocalName(), "Argentina");
        assertEquals(country.getGovernmentForm(), "Federal Republic");
        assertEquals(country.getHeadOfState(), "Fernando de la Rúa");
        assertEquals(country.getCapitalCity().getId(), 69);
    }

    // ------------------------------------- Test getAllCountriesInTheWorld() -------------------------------------

    @Test
    void testGetAllCountriesInTheWorld()
    {
        ArrayList<Country> countries = app.getAllCountriesInTheWorld();

        //Check to see that the number of rows in query is correct
        assertEquals(239, countries.size());
    }

    // ------------------------------------- Test getAllCountriesInTheWorld() -------------------------------------

    @Test
    void testGetAllCountriesInContinentWrongContinent()
    {
        //Get list of countries in europe
        ArrayList<Country> countries = app.getAllCountriesInContinent("E");

        //Check to see that the number of rows in query is correct
        assertEquals(0, countries.size());
    }

    @Test
    void testGetAllCountriesInContinent()
    {
        //Get list of countries in europe
        ArrayList<Country> countries = app.getAllCountriesInContinent("Europe");

        //Check to see that the number of rows in query is correct
        assertEquals(46, countries.size());
    }


}
