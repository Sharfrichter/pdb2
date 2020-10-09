package pack;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public static void getSubscribedInformation(){
        try{
            List<SubscribedMagazine> subscribedMagazineList = new ArrayList<>();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbz2", "root", "root");
            Statement statement = connection.createStatement();
            System.out.println("Введите дату подписки");
            int year=new Scanner(System.in).nextInt();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subscribed");
            while (resultSet.next()) {
                SubscribedMagazine magazine = new SubscribedMagazine();
                magazine.setId(resultSet.getInt(1));
                magazine.setName(resultSet.getString(2));
                magazine.setDateOfBegin(format.parse(resultSet.getString(3)));
                magazine.setDateOfEnd(format.parse(resultSet.getString(4)));
                magazine.setCost(resultSet.getInt(5));
                magazine.setPeriod(resultSet.getString(6));
                magazine.setDeliveryType(resultSet.getString(7));
                subscribedMagazineList.add(magazine);
            }
            GregorianCalendar calendar = new GregorianCalendar();
            for(SubscribedMagazine magazine:subscribedMagazineList){
                calendar.setTime(magazine.getDateOfBegin());
                if(calendar.get(Calendar.YEAR)==year)
                    System.out.println(magazine);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
