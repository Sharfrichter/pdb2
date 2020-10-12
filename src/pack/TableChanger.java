package pack;

import java.sql.*;
import java.util.Scanner;

public class TableChanger {
    private String tableName;
    private int columns;
    private  String[]columnsName;
    private Connection connection;
    public TableChanger(String tableName, int columns, String[] columnsName) {
        this.tableName=tableName;
        this.columns=columns;
        this.columnsName=columnsName;
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbz2", "root", "root");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void addRecord(){
        try {
            Scanner scanner=new Scanner(System.in);
            Statement statement = connection.createStatement();
            StringBuilder statementBuilder = new StringBuilder("INSERT INTO "+tableName+" VALUES(");
            for(int i=0;i<columns-1;i++){
                System.out.println(columnsName[i]);
                statementBuilder.append("'").append(scanner.nextLine()).append("'").append(",");
            }
            System.out.println(columnsName[columns-1]);
            statementBuilder.append("'").append(scanner.nextLine()).append("'").append(")");
            statement.executeUpdate(statementBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    
    public void changeRecord()//функция изменения записи
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id записи которую нужно сменить");
            int id=scanner.nextInt();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " +tableName+" WHERE id="+id);
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
            statement.executeUpdate("UPDATE "+ tableName+" SET "+column+"="+"'"+value+"'"+" WHERE id="+id);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void deleteRecord()//фунция удаления записи
    {
        try{
            Statement statement=connection.createStatement();
            System.out.println("Введите id для удаления");
            String id=new Scanner(System.in).nextLine();
            statement.executeUpdate("DELETE FROM "+tableName+" WHERE id="+id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String[] getColumnsName() {
        return columnsName;
    }

    public void setColumnsName(String[] columnsName) {
        this.columnsName = columnsName;
    }
}
