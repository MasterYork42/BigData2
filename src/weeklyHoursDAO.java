import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class weeklyHoursDAO {
    public static Connection c;

    public static ArrayList<String[]> getWeeklyHours(String word)
    {   Statement s;
        ArrayList <String[]> result = new ArrayList<String[]>();

        try
        {

            Class.forName("org.postgresql.Driver");
            c= DriverManager.getConnection("jdbc:postgresql://reddwarf.cs.rit.edu:5432/p62004b","p62004b", "ShohzohShohphee7ier8");
            s = c.createStatement();



            String sql = "SELECT mon_op, mon_cl, tue_op, tue_cl, wed_op, wed_cl, thu_op, thu_cl, fri_op, fri_cl, sat_op, sat_cl, sun_op, sun_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            //close maybe
            ResultSet rs = s.executeQuery(sql);
            result = new ArrayList<String[]>();
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = rs.getString(i + 1);
                }
                result.add(row);

            }
            rs.close();
            s.close();
            c.close();;

        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }





        return result;

    }
}