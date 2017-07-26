import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by williamyork on 7/24/17.
 */
public class Main {
    public static void main(String [] args) throws SQLException, ClassNotFoundException
    {
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter you desired choice:");
            System.out.println("(1) Current open restaurants");
            System.out.println("(2) Search for restaurant");
            System.out.println("(3) List restaurants");
            System.out.println("(4) End Program");
            int n = scan.nextInt();

            if(n==1)
            {
                ArrayList<String> temp = OpenDAO.getOpen();
                temp.removeAll(Arrays.asList(null,"", " "));
                for(int i=0; i< temp.size(); i++) {
                    String hold = Integer.toString(i+1) +".) " + temp.get(i);
                    System.out.println(hold);

                }

            }

            if(n==2)
            {


            }

            if(n==3)
            {
                ArrayList <String> temp = RestaurantsDAO.getRestaurantNames();
                temp.removeAll(Arrays.asList(null,"", " "));
                for(int i=0; i< temp.size(); i++) {
                    String hold = Integer.toString(i+1) +".) " + temp.get(i);
                    System.out.println(hold);

                }
            }

            if(n==4)
            {
                break;

            }

        }





    }

}
