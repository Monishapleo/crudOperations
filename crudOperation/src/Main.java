import java.sql.*;
import java.util.Scanner;
//This class contains main method
public class Main {
    public static void main(String[] args) {
        DbService dbService= new DbService();
        try(Scanner scanner=new Scanner(System.in);){
            boolean isRunning=true;
            while (isRunning){
                System.out.println("Below are the list of operation select one of your choice");
                System.out.println("1.Insert data");
                System.out.println("2.Query all data");
                System.out.println("3.Query data by ID");
                System.out.println("4.Delete data");
                System.out.println("5.Update a data");
                System.out.println("6.Exit");

                int choice=scanner.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter id,name,email");
                        dbService.insertUser(new UserDetails(scanner.nextInt(),scanner.next(),scanner.next()));
                        break;
                    case 2:
                        System.out.println("List of users are: ");
                        dbService.getAllUser();
                        break;
                    case 3:
                        System.out.println("Enter an ID");
                        dbService.getUserById(scanner.nextInt());
                        break;
                    case 4:
                        System.out.println("Enter an ID");
                        dbService.deleteUserById(scanner.nextInt());
                        break;
                    case 5:
                        System.out.println("Enter user id");
                        int id=scanner.nextInt();
                        if(dbService.getUserById(id).containsValue(id)) {
                            UserDetails userDetails = new UserDetails(id,scanner.next(), scanner.next());
                            dbService.updateUser(userDetails);
                        }
                        else {
                            System.out.println("No such record found");
                        }
                        break;
                    case 6:
                        System.out.println("Thank you visit again");
                        isRunning=false;
                    default:
                        System.out.println("Incorrect Choice!!!!!!");
                        break;

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong" + e);
        }

    }
}
