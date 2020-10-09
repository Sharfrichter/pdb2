package pack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SubscribedMagazine {
    private int id;
    private String name;
    private Date dateOfBegin;
    private Date dateOfEnd;
    private int cost;
    private int period;
    private String deliveryType;


    public Date getDateOfBegin() {
        return dateOfBegin;
    }

    public void setDateOfBegin(Date dateOfBegin) {
        this.dateOfBegin = dateOfBegin;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return id + " " + name + " " + format.format(dateOfBegin) + " " + format.format(dateOfEnd) + " " + cost + " " + period + " " + deliveryType;
    }
}
