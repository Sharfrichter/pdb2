package pack;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReceiveMagazineChanger {
    public ReceiveMagazineChanger() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbz2", "root", "root");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    Connection connection;
    private String[] questions={"подписной индекс","название","дата начала подписки(гггг-мм-дд)","дата окончания(гггг-мм-дд)","цена","периодичность","тип доставки"};
    public void addRecord()//Функция добавления в таблицу
    {
        try {
            SubscribedMagazine magazine=new SubscribedMagazine();
            Scanner scanner=new Scanner(System.in);
            Statement statement = connection.createStatement();
            StringBuilder statementBuilder = new StringBuilder("INSERT INTO subscribed VALUES(");
            for(int i=0;i<6;i++){
                System.out.println(questions[i]);
                statementBuilder.append("'").append(scanner.nextLine()).append("'").append(",");
            }
            System.out.println(questions[6]);
            statementBuilder.append("'").append(scanner.nextLine()).append("'").append(")");
            System.out.println(statementBuilder);
            statement.executeUpdate(statementBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    };
    public void changeRecord()//функция изменения записи
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id записи которую нужно сменить");
            int id=scanner.nextInt();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subscribed WHERE id="+id);
            while (resultSet.next()){
                ResultSetMetaData metaData=resultSet.getMetaData();
                for(int i=1;i<8;i++){
                    System.out.println(metaData.getColumnName(i)+":"+resultSet.getString(i));
                }
            }

            System.out.println("введите название колонки");
            String column=new Scanner(System.in).nextLine();
            System.out.println("введите значение колонки");
            String value=new Scanner(System.in).nextLine();
            statement.executeUpdate("UPDATE subscribed SET "+column+"="+"'"+value+"'"+" WHERE id="+id);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void deleteRecord()//фунция удаления записи
    {

    }
}
