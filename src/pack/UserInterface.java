package pack;

import java.util.Scanner;

public class UserInterface {

    public void run(){
        String[] columnsSubscribed={"подписной индекс","название","дата начала подписки(гггг-мм-дд)","дата окончания(гггг-мм-дд)","цена","периодичность","тип доставки"};
        String[] columnsReceived={"подписной индекс","название","дата получения(гггг-мм-дд)","номер","имя получившего сотрудника","должность"};
        String[] columnsEmployee = {"Имя", "Должность"};
        TableChanger subscribedChanger = new TableChanger("subscribed",7,columnsSubscribed);
        TableChanger receivedChanger = new TableChanger("received",6,columnsReceived);
        TableChanger employeeChanger = new TableChanger("employee", 2, columnsEmployee);
        Scanner scanner=new Scanner(System.in);
        int flag=10;
        while (flag!=0){
            System.out.println("Выберите действие");
            System.out.println("0. Выход");
            System.out.println("1. Вывод информации из таблицы");
            System.out.println("2. Фиксирование факта получения");
            System.out.println("3. Просмотр списка изданий на выбранный год");
            System.out.println("4. Просмотр списка изданий не полученных за предыдущие 2 месяца");
            System.out.println("5. Просмотр имени сотрудника получившего издание");
            System.out.println("6. Добавление/редактирование/удаление информации");
            flag = scanner.nextInt();
            switch (flag){
                case 0:{
                    return;
                }
                case 1: {
                    InformationAboutMagazines.getInformation();
                    break;
                }
                case 2:{
                    receivedChanger.addRecord();
                    break;
                }
                case 3:{
                    InformationAboutMagazines.getSubscribedInformation();
                    break;
                }
                case 4:{
                    InformationAboutMagazines.getReceivedInformation();
                    break;
                }
                case 5:{
                    InformationAboutMagazines.getInformationAboutEmployee();
                    break;
                }
                case 6:{
                    int action=0;
                    int table=0;
                    System.out.println("Выберите действие 1:добавление 2:редактирование 3:удаление");
                    action = scanner.nextInt();
                    System.out.println("Выберите таблицу 1:подписки 2:сотрудники");
                    table = scanner.nextInt();
                    if(table==1){
                        switch (action){
                            case 1:{
                                subscribedChanger.addRecord();
                                break;
                            }
                            case 2:{
                                subscribedChanger.changeRecord();
                                break;
                            }
                            case 3:{
                                subscribedChanger.deleteRecord();
                                break;
                            }
                        }
                    }
                    if(table==2){
                        switch (action){
                            case 1:{
                                employeeChanger.addRecord();
                                break;
                            }
                            case 2:{
                                employeeChanger.changeRecord();
                                break;
                            }
                            case 3:{
                                employeeChanger.deleteRecord();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
