package com.napier.sem;
import com.napier.sem.classes.Country;

import java.sql.*;

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
        a.connect();
        // Display results

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "sem_group_project");
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
                    "SELECT departments.dept_no, departments.dept_name, dept_manager.emp_no "
                            + "FROM departments, dept_manager "
                            + "WHERE departments.dept_no = dept_manager.dept_no "
                            + "AND dept_manager.to_date = '9999-01-01' "
                            + "AND departments.dept_name = '" + dept_name + "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()) {
                // Extract department information
                Country country = new Country();
                dept.dept_no = rset.getString("departments.dept_no");
                dept.dept_name = rset.getString("departments.dept_name");
                //Manager will be set in the getEmployee() method
                dept.manager = getEmployee(rset.getInt("dept_manager.emp_no"), true, dept);

                //return the department
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
}