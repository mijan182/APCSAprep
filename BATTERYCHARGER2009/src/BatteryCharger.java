public class BatteryCharger
{
  /** rateTable has 24 entries representing the charging costs for hours 0 through 23. */
  private int[] rateTable  = {50, 60, 160, 60, 80, 100, 100, 120,
                       150, 150, 150, 200, 40, 240, 220, 220, 
                       200, 200, 180, 180, 140, 100, 80, 60};
  
  
  /** Determines the total cost to charge the battery starting at the beginning of startHour.
    * @param startHour the hour at which the charge period begins
    * Precondition: 0 ? startHour ? 23
    * @param chargeTime the number of hours the battery needs to be charged
    * Precondition: chargeTime > 0
    * @return the total cost to charge the battery
    */
  private int getChargingCost(int startHour, int chargeTime)
  { 
    /* to be implemented in part (a) */ 

    int cost = 0;
    int rIndex = startHour;
      for (int h=1; h<=chargeTime;h++){
        cost +=rateTable[rIndex];

        rIndex++;

        if(rIndex==rateTable.length)
          rIndex=0;
      }
    return cost;
  }
  
  /** Determines start time to charge the battery at the lowest cost for the given charge time.
    * @param chargeTime the number of hours the battery needs to be charged
    * Precondition: chargeTime > 0
    * @return an optimal start time, with 0 ? returned value ? 23
    */
  public int getChargeStartTime(int chargeTime)
  { 
    /* to be implemented in part (b) */ 

    int cheapestStartHour = 0;

    for(int startHour = 1; startHour<rateTable.length; startHour++)
     if(getChargingCost(startHour,chargeTime)<
      getChargingCost(cheapestStartHour,chargeTime))
    cheapestStartHour = startHour;

    return cheapestStartHour;
  }
  
  public static void main(String[] args)
  {
    int cost = 0;
    BatteryCharger charger = new BatteryCharger();
    cost = charger.getChargingCost(12, 1);
    System.out.println(cost);
    cost = charger.getChargingCost(0, 2);
    System.out.println(cost);
    cost = charger.getChargingCost(22,7);
    System.out.println(cost);
    cost = charger.getChargingCost(22,30);
    System.out.println(cost);
    int time = charger.getChargeStartTime(1);
    System.out.println(time);
    time = charger.getChargeStartTime(2);
    System.out.println(time);
    time = charger.getChargeStartTime(7);
    System.out.println(time);
    time = charger.getChargeStartTime(30);
    System.out.println(time);
  }

}