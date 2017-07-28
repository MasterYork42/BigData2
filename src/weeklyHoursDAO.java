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



            String sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
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
                    row[i] = "Monday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();



            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT mon_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Monday Close: " + rs.getString(i + 1) +"\n\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT tue_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Tuesday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT tue_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Tuesday Close: " + rs.getString(i + 1) +"\n\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();



            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT wed_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Wednesday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT wed_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Wednesday Close: " + rs.getString(i + 1) +"\n\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT thu_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Thursday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT thu_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Thursday Close: " + rs.getString(i + 1) +"\n\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT fri_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Friday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT fri_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Friday Closed: " + rs.getString(i + 1) +"\n\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT sat_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Saturday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();

            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT sat_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Saturday Closed: " + rs.getString(i + 1) +"\n\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();


            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT sun_op FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Sunday Open: " + rs.getString(i + 1) +"\n";
                }
                result.add(row);

            }
            rs.close();
            s.close();



            s = c.createStatement();

            sql = "SELECT hourr FROM hourtab WHERE hr_id=" + "(SELECT sun_cl FROM location_open_close_time WHERE location_id = " +
                    "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs')";

            //String sql ="SELECT  hourr FROM hourtab WHERE hr_id =(SELECT mon_op FROM location_open_close_time WHERE location_id = " +
            //       "(SELECT location_id FROM dining_locations WHERE location_desc = \'" + word+ "\') AND semester='fs'";

            rs = s.executeQuery(sql);
            columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()){

                String[] row = new String[columnCount];
                for (int i = 0; i <columnCount ; i++)
                {
                    row[i] = "Sunday Closed: " + rs.getString(i + 1) +"\n\n";
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