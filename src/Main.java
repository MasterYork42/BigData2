import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
                ArrayList<String> temp = searchRDAO.getRestaurantHours();
                temp.removeAll(Arrays.asList(null,"", " "));
                for(int i=0; i< temp.size(); i++) {
                    String hold = Integer.toString(i+1) +".) " + temp.get(i);
                    System.out.println(hold);

                }

                if(temp.size()<2)
                {   while(true)
                    {
                    System.out.println("What information do you want about this restaurant?");
                    System.out.println("1.) Weekly hours");
                    System.out.println("2.) Hours Today ");
                        System.out.println("3.) Exit Program");
                        int h = scan.nextInt();

                        if(h==1)
                        {
                            ArrayList<String[]> temp2 = weeklyHoursDAO.getWeeklyHours(temp.get(0));
                            temp.removeAll(Arrays.asList(null,"", " "));
                            for(int i=0; i< temp2.size(); i++) {
                                String[] hold = temp2.get(i);
                                System.out.println(hold.toString());

                            }

                        }

                        if(h==2)
                        {


                        }

                        if(h==3)
                        {
                            break;

                        }

                    }


                }

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
