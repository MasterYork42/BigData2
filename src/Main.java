import java.util.ArrayList;
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


            }

            if(n==2)
            {


            }

            if(n==3)
            {
                ArrayList <String> temp = RestaurantsDAO.getRestaurantNames();
                for(int i=0; i< temp.size(); i++) {
                    System.out.println(temp.get(i));

                }
            }

            if(n==4)
            {
                break;

            }

        }





    }

}
