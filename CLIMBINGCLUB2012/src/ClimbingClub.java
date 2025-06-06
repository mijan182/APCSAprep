import java.util.List;
import java.util.ArrayList;

/**
 * @author: Barb Ericson
 * ericson@cc.gatech.edu
 */
public class ClimbingClub 
{ 



  /** The list of climbs completed by members of the club. 
    * * Guaranteed not to be null. Contains only non-null references. 
    */ 
  private List<ClimbInfo> climbList; 
  
  /** Creates a new ClimbingClub object. */ 
  public ClimbingClub() 
  { 
    climbList = new ArrayList<ClimbInfo>(); 
  } 
  


  /** Adds a new climb with name peakName and time climbTime to the end of the list of climbs  
    * 
    * @param peakName the name of the mountain peak climbed 
    * @param climbTime the number of minutes taken to complete the climb 
    */ 
  public void addClimbA(String peakName, int climbTime) 
  { 
    climbList.add(new ClimbInfo(peakName, climbTime));
  } 
  
  


  /** Adds a new climb with name peakName and time climbTime to the list of climbs in order by name using 
    * String compareTo to figure alphabetic order
    * 
    * @param peakName the name of the mountain peak climbed 
    * @param climbTime the number of minutes taken to complete the climb 
    */ 
  public void addClimbB(String peakName, int climbTime) 
  { 
   int i = 0;
   while(i<climbList.size() &&
            peakName.compareTo(climbList.get(i).getName()) > 0)
            i++;
    climbList.add(i, new ClimbInfo(peakName, climbTime));
  }
  
/*ANSWERS TO PART C:
 * (I)NO - Since peak names aren't in order, two identical names
 *  could appear at different places in the list, and this method
 *  would count them a s distinct when theyre not.
 *(II)YES - Identical names will be grouped together, this method
  correctly counts unique names compared to the previous one

  basically, the implementation doesn't require the list to be
  sorted, but does require that all climbs with the same peak
  name be adjacent to each other/be together.
 */


  /** @return the number of distinct names in the list of climbs */
  public int distinctPeakNames() 
  { 
    if (climbList.size() == 0) 
    { 
      return 0; 
    } 
    ClimbInfo currInfo = climbList.get(0); 
    String prevName = currInfo.getName(); 
    String currName = null; int numNames = 1; 
    for (int k = 1; k < climbList.size(); k++) 
    { 
      currInfo = climbList.get(k); 
      currName = currInfo.getName(); 
      if (prevName.compareTo(currName) != 0) 
      { 
        numNames++; prevName = currName; 
      } 
    }
    return numNames;
  }
  
  public String toString()
  {
    String output ="";
    for (ClimbInfo info : climbList)
    {
      output = output + info.toString() + "\n";
    }
    return output;
  }
  
   public static void main(String[] args)
  {
    // test a 
    ClimbingClub hikerClub = new ClimbingClub(); 
    hikerClub.addClimbA("Monadnock", 274); 
    hikerClub.addClimbA("Monadnock", 344);
    hikerClub.addClimbA("Whiteface", 301); 
    hikerClub.addClimbA("Algonquin", 225); 
    System.out.print(hikerClub);
    System.out.println("The order printed above should be Monadnock, Whiteface, Algonquin, Monadnock");
    System.out.println("Distinct peaks is " + hikerClub.distinctPeakNames() + " and should be " + 3);
    
    // output an empty line
    System.out.println();
    
    // test b
    hikerClub = new ClimbingClub();
    hikerClub.addClimbB("Monadnock", 274); 
    hikerClub.addClimbB("Monadnock", 344);
    hikerClub.addClimbB("Whiteface", 301); 
    hikerClub.addClimbB("Algonquin", 225); 
    System.out.print(hikerClub);  
    System.out.println("The order printed above should be  Algonquin, Monadnock, Monadnock, Whiteface");
    System.out.println("Distinct peaks is " + hikerClub.distinctPeakNames() + " and should be " + 3);
     
  }

}