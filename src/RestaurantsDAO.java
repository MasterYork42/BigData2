import java.sql.*;
import java.util.ArrayList;



public class RestaurantsDAO {
    public static Connection c;

    public static ArrayList<String> getRestaurantNames()
    {   Statement s;
        ArrayList<String> Restaurants = new ArrayList<>();

        try
        {
            Class.forName("org.postgresql.Driver");
            c= DriverManager.getConnection("jdbc:postgresql://reddwarf.cs.rit.edu:5432/p62004b","p62004b", "ShohzohShohphee7ier8");
            //s = c.prepareStatement("SELECT location_id FROM dining_locations");
            s = c.createStatement();
            String sql = "SELECT location_desc FROM dining_locations";

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