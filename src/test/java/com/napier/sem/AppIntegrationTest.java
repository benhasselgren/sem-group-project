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

    @Test
    void testGetAllCountriesInTheWorldLimit()
    {
        ArrayList<Country> countries = app.getAllCountriesInTheWorld(10);

        //Check to see that the number of rows in query is correct
        assertEquals(10, countries.size());
    }

    // ------------------------------------- Test getAllCountriesInContinent() -------------------------------------

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

    @Test
    void testGetAllCountriesInContinentLimit()
    {
        //Get list of countries in europe
        ArrayList<Country> countries = app.getAllCountriesInContinent("Europe", 10);

        //Check to see that the number of rows in query is correct
        assertEquals(10, countries.size());
    }

    // ------------------------------------- Test getAllCountriesInRegion() -------------------------------------

    @Test
    void testGetAllCountriesInRegionWrongRegion()
    {
        //Get list of countries in europe
        ArrayList<Country> countries = app.getAllCountriesInRegion("E");

        //Check to see that the number of rows in query is correct
        assertEquals(0, countries.size());
    }

    @Test
    void testGetAllCountriesInRegion()
    {
        //Get list of countries in Nordic Countries region
        ArrayList<Country> countries = app.getAllCountriesInRegion("Nordic Countries");

        //Check to see that the number of rows in query is correct
        assertEquals(7, countries.size());
    }

    @Test
    void testGetAllCountriesInRegionLimit()
    {
        //Get list of countries in Nordic Countries region
        ArrayList<Country> countries = app.getAllCountriesInRegion("Nordic Countries", 2);

        //Check to see that the number of rows in query is correct
        assertEquals(2, countries.size());
    }
}
