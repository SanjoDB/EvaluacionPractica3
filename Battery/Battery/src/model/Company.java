package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;
    public int counterB= 0;
    public int counterRB= 0;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);
        
    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
        for(int i=0;i<MAX_BATTERIES;i++){
            if(batteries[i]!=null){
                if(batteries[i] instanceof Battery){
                    counterB++;
                } 
                if(batteries[i] instanceof RechargeableBattery){
                    counterRB++;
                }
            }
        }

    	return "No Rechargeable Batteries: " + (counterB-counterRB) + "\n" +
        "Rechargeable Batteries: " + counterRB;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
        for(int i=0;i<MAX_BATTERIES;i++){
            if(batteries[i]!=null){
                if(batteries[i] instanceof Battery){
                    str+= ((Battery)batteries[i]).toString();
                } else if(batteries[i] instanceof RechargeableBattery){
                    str+= ((Battery)batteries[i]).toString();
                }
            }
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
        double str=0;
        for(int i=0;i<MAX_BATTERIES;i++){
            if(batteries[i]!=null){
                if(batteries[i] instanceof RechargeableBattery){
                    str+= ((RechargeableBattery)batteries[i]).calculateUsefullLifeCost()/counterRB;
                }
            }
        }
		return str;
	}

}
