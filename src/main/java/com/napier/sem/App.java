package com.napier.sem;
import com.napier.sem.classes.City;
import com.napier.sem.classes.Country;

import java.sql.*;
import java.util.ArrayList;

/** Main app class.
 * @author SEM Group Project
 */
public class App {
    /**
     * Instance variables.
     */
    private Connection con = null;

    /**
     * Main method.
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

        // Get country result
        Country country = a.getCountry("Argentina");

        //Display country
        a.displayCountry(country);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */

    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "sem_group_project");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Prints a country.
     * @param country The country to print
     */
    public void displayCountry(Country country)
    {
        // Check employees is not null
        if (country != null)
        {
            System.out.println(country.toString());
        }
        else
        {
            System.out.println("No employee");
            return;
        }
    }

    /**
     * Prints a country report.
     * @param countries The list of countries to print
     */
    public void displayCountryReport(ArrayList<Country> countries)
    {

    }

    /**
     * Returns a country.
     * @param country_name The name of the country to return.
     * @return A country
     */
    public Country getCountry(String country_name) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.SurfaceArea, country.IndepYear, country.Population, country.LifeExpectancy, country.GNP, country.GNPOLd, country.LocalName, country.GovernmentForm, country.HeadOfState, country.Capital "
                            + "FROM country "
                            + "WHERE country.Name = '" + country_name + "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()) {
                // Extract country information
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setSurfaceArea(rset.getInt("country.SurfaceArea"));
                country.setIndepYear(rset.getInt("country.IndepYear"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setLifeExpectancy(rset.getDouble("country.LifeExpectancy"));
                country.setGnp(rset.getDouble("country.GNP"));
                country.setGnpold(rset.getDouble("country.GNPOLd"));
                country.setLocalName(rset.getString("country.LocalName"));
                country.setGovernmentForm(rset.getString("country.GovernmentForm"));
                country.setHeadOfState(rset.getString("country.HeadOfState"));
                //Get the city by calling getCity() and passing the city id.
                country.setCapitalCity(getCity(rset.getInt("country.Capital")));

                //return the country
                return country;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Returns a country.
     * @param city_id The id of the city to return.
     * @return A city
     */
    public City getCity(int city_id) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city "
                            + "WHERE city.ID = " + city_id + " ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()) {
                // Extract city information
                City city = new City();
                city.setId(rset.getInt("city.ID"));
                city.setName(rset.getString("city.Name"));
                //Country will be set in getCountry
                city.setCountry(null);
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));

                //return the city
                return city;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
}