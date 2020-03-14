package com.napier.sem;

import com.napier.sem.classes.City;
import com.napier.sem.classes.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/** Tests App class.
 * @author SEM Group Project
 */
public class AppTest
{
    // ------------------------------------- Initialise -------------------------------------
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }


    // ------------------------------------- Test displayCountry() -------------------------------------

    @Test
    void displayCountryTestNull()
    {
        app.displayCountry(null);
    }

    @Test
    void displayCountry()
    {
        //Create a city and a country
        City city = new City(1,"Kabul", "Kabol",1780000);
        Country country = new Country("AFG","Afghanistan","Asia","Southern and Central Asia",652090.00,1919,22720000,45.9,5976.00,0,"Afganistan/Afqanestan","Islamic Emirate","Mohammad Omar",city);

        //Assign country to to city then, city to country
        city.setCountry(country);
        country.setCapitalCity(city);

        //Call the display country method
        app.displayCountry(country);
    }

    // ------------------------------------- Test displayCountryReport() -------------------------------------

    @Test
    void displayCountryReportTestNull()
    {
        app.displayCountryReport(null);
    }

}
