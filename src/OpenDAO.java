import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class OpenDAO {
    public static Connection c;

    public static ArrayList<String> getOpen() {
        Statement s;
        ArrayList<String> open = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://reddwarf.cs.rit.edu:5432/p62004b", "p62004b", "ShohzohShohphee7ier8");
            //s = c.prepareStatement("SELECT location_id FROM dining_locations");
            s = c.createStatement();
            Date now = new Date();
            DateFormat df = new SimpleDateFormat("HH:mm");
            Date dateobj = new Date();
            String time_n = df.format(dateobj);
            time_n = getNear15Minute(time_n);

            SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
            String date = simpleDateformat.format(now).toLowerCase();
            String sql = "SELECT location_desc FROM dining_locations  " +
                    " WHERE location_id IN ( SELECT location_id FROM location_open_close_time WHERE " + date + "_op <" +
                    " (SELECT hr_id FROM hourtab WHERE hourr = " + time_n + ") AND " + date + "_cl > (SELECT hr_id FROM hourtab WHERE hourr = " + time_n + ") )";

            //close maybe
            ResultSet rs = s.executeQuery(sql);
            open = new ArrayList<String>();
            while (rs.next()) {
                open.add(rs.getString(1));

            }
            rs.close();
            s.close();
            c.close();
            ;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        return open;

    }

    public static String getNear15Minute(String time) {
        String[] temp = time.split("");
        String temp2 = temp[3] + temp[4];
        int minutes = Integer.parseInt(temp2);
        int mod = minutes % 15;
        int res = 0;
        if ((mod) >= 8) {
            res = minutes + (15 - mod);
        } else {
            res = minutes - mod;
        }
        int fin = res % 60;

        if (fin >=8) {
            return ("\'" + temp[0] + temp[1] + temp[2] + String.valueOf(fin) + ":00" + "\'");
        } else{return ("\'" + temp[0] + temp[1] + temp[2] + "00" + ":00" + "\'");}
    }
}
