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
                System.out.println("3.) Average number of Transactions in this hour");
                System.out.println("4.) Average number of Transactions for this Day");
                System.out.println("5.) How many transaction in a given hour");
                System.out.println("6.) How many transactions on a certain day");
                System.out.println("7.) Exit ");
                int h = scan.nextInt();

                if(h==1)
                {
                    ArrayList<String[]> temp2 = weeklyHoursDAO.getWeeklyHours(temp.get(0));
                    temp.removeAll(Arrays.asList(null,"", " "));
                    for(int i=0; i< temp2.size(); i++) {
                        String[] hold = temp2.get(i);
                        System.out.println(hold[0].toString());

                    }

                }

                if(h==2)
                {
                    ArrayList<String[]> temp2 = todayHoursDAO.getTodayHours(temp.get(0));
                    temp.removeAll(Arrays.asList(null,"", " "));
                    for(int i=0; i< temp2.size(); i++) {
                        String[] hold = temp2.get(i);
                        System.out.println(hold[0].toString());

                    }

                }
                if(h==3)
                {
                    int temp2 = transactionsHourDAO.transhour(temp.get(0),"");
                    if(temp2==0) {
                        System.out.println("This restaurant is closed during this hour" + "\n");
                    } else{
                    System.out.println("The average number of transaction in this hour is: " + temp2 +"\n");}

                }

                if(h==4) {
                    int temp2 = transactionsDayDAO.transDay(temp.get(0),"","");
                    if(temp2==0) {
                        System.out.println("This restaurant is closed on this day during this semester" + "\n");
                    } else{
                    System.out.println("The average number of transaction on this day is: " + temp2 +"\n");}

                }
                if(h==5)
                {
                    System.out.println("Enter hour in military time you would like to see (ex: 1pm would be 13)");
                    String hh= scan.nextLine();
                    int temp2 = transactionsHourDAO.transhour(temp.get(0),"");
                    if(temp2==0) {
                        System.out.println("This restaurant is closed during this hour" + "\n");
                    } else{
                        System.out.println("The average number of transaction in this hour is: " + temp2 +"\n");}

                }

                if(h==6)
                {
                    System.out.println("Enter Month in integer form (ex: 11 for November");
                    String l  =scan.next();
                    System.out.println("Enter Day of Week (ex: wednesday)");
                    String k = scan.next();
                    int temp2 = transactionsDayDAO.transDay(temp.get(0),l,k);
                    if(temp2==0) {
                        System.out.println("This restaurant is closed on this day during this semester" + "\n");
                    } else{
                        System.out.println("The average number of transaction on this day is: " + temp2 +"\n");}

                }



                if(h==7)
                {
                    break;

                }
            }


            }

                if(temp.size()>1)
                {
                    System.out.println("Select number for desired restaurant");
                    int temp3= scan.nextInt();



                    while(true)
                    {
                        System.out.println("What information do you want about this restaurant?");
                        System.out.println("1.) Weekly hours");
                        System.out.println("2.) Hours Today ");
                        System.out.println("3.) Average number of Transactions in this hour");
                        System.out.println("4.) Average number of Transactions for this Day");
                        System.out.println("5.) How many transaction in a given hour");
                        System.out.println("6.) How many transactions on a certain day");
                        System.out.println("7.) Exit ");
                    int h = scan.nextInt();

                    if(h==1)
                    {
                        ArrayList<String[]> temp2 = weeklyHoursDAO.getWeeklyHours(temp.get(temp3-1));
                        temp.removeAll(Arrays.asList(null,"", " "));
                        for(int i=0; i< temp2.size(); i++) {
                            String[] hold = temp2.get(i);
                            System.out.println(hold[0].toString());

                        }

                    }

                    if(h==2)
                    {
                        ArrayList<String[]> temp2 = todayHoursDAO.getTodayHours(temp.get(temp3-1));
                        temp.removeAll(Arrays.asList(null,"", " "));
                        for(int i=0; i< temp2.size(); i++) {
                            String[] hold = temp2.get(i);
                            System.out.println(hold[0].toString());

                        }

                    }

                      if(h==3)
                    {
                        int temp2 = transactionsHourDAO.transhour(temp.get(temp3-1),"");
                        if(temp2==0) {
                            System.out.println("This restaurant is closed during this hour" + "\n");
                        } else{
                            System.out.println("The average number of transaction in this hour is: " + temp2 +"\n");}

                    }

                        if(h==4) {
                            int temp2 = transactionsDayDAO.transDay(temp.get(temp3-1),"","");
                            if(temp2==0) {
                                System.out.println("This restaurant is closed on this day during this semester" + "\n");
                            } else{
                                System.out.println("The average number of transaction on this day is: " + temp2 +"\n");}

                        }
                        if(h==5)
                        {
                            System.out.println("Enter hour in military time you would like to see (ex: 1pm would be 13)");
                            String hh= scan.nextLine();
                            int temp2 = transactionsHourDAO.transhour(temp.get(0),"");
                            if(temp2==0) {
                                System.out.println("This restaurant is closed during this hour" + "\n");
                            } else{
                                System.out.println("The average number of transaction in this hour is: " + temp2 +"\n");}
                        }

                        if(h==6)
                        {
                            System.out.println("Enter Month in integer form (ex: 11 for November");
                            String l  =scan.next();
                            System.out.println("Enter Day of Week (ex: wednesday)");
                            String k = scan.next();
                            int temp2 = transactionsDayDAO.transDay(temp.get(temp3-1),l,k);
                            if(temp2==0) {
                                System.out.println("This restaurant is closed on this day during this semester" + "\n");
                            } else{
                                System.out.println("The average number of transaction on this day is: " + temp2 +"\n");}

                        }

                        if(h==7)
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
