package pack;

import java.sql.*;
import java.util.Scanner;

public abstract class InformationAboutMagazines {

    public static void getInformation()  {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbz2", "root", "root");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want information about subscribed or received magazines (1/2)");
            if (scanner.nextInt() == 1) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM subscribed");
                while (resultSet.next()) {
                    for(int i=1;i<8;i++){
                        System.out.print(resultSet.getString(i)+" ");
                    }
                    System.out.println();
                }
            } else {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM received");
                while (resultSet.next()) {
                    for(int i=1;i<7;i++){
                        System.out.print(resultSet.getString(i)+" ");
                    }
                    System.out.println();
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
