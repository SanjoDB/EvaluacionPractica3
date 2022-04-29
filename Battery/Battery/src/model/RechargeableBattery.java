package model;

public class RechargeableBattery extends Battery{

    private int chargerNumber;
    private char type;
    public final static char BATTERY_LITIO = 'l';
    public final static char BATTERY_NIQUEL_CADIO = 'n';
    public final static double FACTOR_LITIO = 0.92;
    public final static double FACTOR_NIQUEL_CADIO = 0.8;

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type){

        super(name, voltage, cost, capacity);
        this.chargerNumber=chargerNumber;
        this.type=type;

    }

    public int getChargerNumber(){

        return chargerNumber;

    }

    public void setChargerNumber(int chargerNumber){

        this.chargerNumber=chargerNumber;

    }

    public char getType(){

        return type;

    }

    public void setType(char type){

        this.type=type;

    }

    public double calculateUsefullLifeCost(){

        double str=0;

        if(getType()=='l'){
            str= (super.cost * super.voltage * super.capacity)/(1000 * getChargerNumber() * FACTOR_LITIO);
        } else if(getType()=='n'){
            str= (super.cost * super.voltage * super.capacity)/(1000 * getChargerNumber() * FACTOR_NIQUEL_CADIO);
        }

        return str;
    }

    public String toString(){

        return "Rechargeable Battery \n" +
        "Name: " + super.name + "\n" +
        "Usefull Life Cost: " +  calculateUsefullLifeCost() +"\n";

    }
}