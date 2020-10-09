package pack;


import java.text.ParseException;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws ParseException {
        String[] columnsSubscribed={"подписной индекс","название","дата начала подписки(гггг-мм-дд)","дата окончания(гггг-мм-дд)","цена","периодичность","тип доставки"};
        String[] columnsReceived={"подписной индекс","название","дата получения(гггг-мм-дд)","номер","имя получившего сотрудника","должность"};
        String[] columnsEmployee = {"Имя", "Должность"};
        Changer subscribedChanger = new Changer("subscribed",7,columnsSubscribed);
        Changer receivedChanger = new Changer("received",6,columnsReceived);
        Changer employeeChanger = new Changer("employee", 2, columnsEmployee);
        //subscribedChanger.addRecord();
        //InformationAboutMagazines.getInformation();
        InformationAboutMagazines.getSubscribedInformation();
    }

}
