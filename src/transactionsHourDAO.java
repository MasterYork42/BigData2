import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class transactionsHourDAO {
    public static Connection c;

    public static int transhour(String word, String hour) {
        Statement s;
        int open = 0;
        int open2 =0;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://reddwarf.cs.rit.edu:5432/p62004b", "p62004b", "ShohzohShohphee7ier8");
            //s = c.prepareStatement("SELECT location_id FROM dining_locations");
            s = c.createStatement();
            Date now = new Date();
            DateFormat df = new SimpleDateFormat("MM");
            Date dateobj = new Date();
            String time_n = df.format(dateobj);
            DateFormat tf = new SimpleDateFormat("HH");
            Date dateob = new Date();
            String time_m= tf.format(dateob);
            if(!hour.isEmpty())
            {
                time_m=hour;

            }

            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String h2 =new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
            h2= h2.toUpperCase();






            String sql = "SELECT COUNT (*)" +
                    "FROM transactions WHERE day_of_week = \'" + h2 +"\' AND location_id = (SELECT location_id FROM dining_locations WHERE location_desc =\'" + word + "\')" +
                    "AND Extract (Month From trandate) = \'" + time_n + "\' AND EXTRACT (HOUR FROM trandate) = \'" + time_m + "\'";

           // String sql = "SELECT COUNT (*) " +
           //         "FROM transactions WHERE day_of_week = 'FRIDAY' AND  location_id = (SELECT location_id FROM dining_locations WHERE location_desc =\'"+ word +"\')" +
            //        "AND Extract (Month From trandate) = '04'";

            //close maybe
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                open= (rs.getInt(1));

            }
            rs.close();
            s.close();

            s = c.createStatement();
            sql ="SELECT count ( DISTINCT extract(DAY FROM trandate)) FROM  transactions WHERE day_of_week = \'" + h2 + "\'  AND extract(MONTH from trandate) = \'" + time_n + "\' ";
            //sql = "SELECT count ( DISTINCT extract(DAY FROM trandate)) FROM  transactions WHERE day_of_week = 'FRIDAY' AND extract(MONTH from trandate) = '04' ";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                open2= (rs.getInt(1));

            }

            rs.close();
            s.close();
            c.close();

            ;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if(open==0 || open2 ==0)
        {return 0;}
        else{
            return open / open2;}

    }


}
