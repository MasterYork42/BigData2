import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class searchRDAO {
    public static Connection c;

    public static ArrayList<String> getRestaurantHours()
    {   Statement s;
        ArrayList<String> Restaurants = new ArrayList<>();
        Scanner scan= new Scanner(System.in);
        try
        {
            System.out.println("What restaurant do you want data for?");
            String temp = scan.nextLine();
            Class.forName("org.postgresql.Driver");
            c= DriverManager.getConnection("jdbc:postgresql://reddwarf.cs.rit.edu:5432/p62004b","p62004b", "ShohzohShohphee7ier8");
            s = c.createStatement();
            temp= temp.toUpperCase();


            String sql = "SELECT location_desc FROM dining_locations WHERE location_desc LIKE (\'%" + temp +"%\');";

            //close maybe
            ResultSet rs = s.executeQuery(sql);
            Restaurants = new ArrayList<String>();
            while (rs.next()){
                Restaurants.add(rs.getString(1));

            }
            rs.close();
            s.close();
            c.close();;

        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }





        return Restaurants;

    }
}