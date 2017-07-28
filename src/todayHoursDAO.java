import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class todayHoursDAO {
    public static Connection c;

    public static ArrayList<String[]> getTodayHours(String word) {
        Statement s;
        ArrayList<String[]> result = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://reddwarf.cs.rit.edu:5432/p62004b", "p62004b", "ShohzohShohphee7ier8");
            //s = c.prepareStatement("SELECT location_id FROM dining_locations");
            s = c.createStatement();
            Date now = new Date();
            DateFormat df = new SimpleDateFormat("HH:mm");
            Date dateobj = new Date();
            String time_n = df.format(dateobj);


            SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
            String date = simpleDateformat.format(now).toLowerCase();
            String sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT "+ date +"_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            ResultSet rs = s.executeQuery(sql);
            result = new ArrayList<String[]>();
            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();
            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT "+ date +"_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

             rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Close: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            c.close();
            ;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        return result;

    }


}
