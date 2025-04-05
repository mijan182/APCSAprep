public class APLine
{
  private int a,b,c;

  public APLine(int a, int b, int c){
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double getSlope(){
    return -a / (double)b;
  }

  public boolean isOnLine(int x, int y){
    return a*x+b*y+c == 0;
  }
  
  public static void main(String[] args)
  {
    APLine line1 = new APLine(5, 4, -17);
    double slope1 = line1.getSlope(); // slope1 is assigned -1.25
    System.out.println("slope1 should be -1.25 and is " + slope1);
    boolean onLine1 = line1.isOnLine(5, -2); // true because 5(5) + 4(-2) + (-17) = 0
    System.out.println("onLine1 should be true and is " + onLine1);
                       
    APLine line2 = new APLine(-25, 40, 30);
    double slope2 = line2.getSlope(); // slope2 is assigned 0.625
    System.out.println("slope2 should be 0.625 and is " + slope2);
    boolean onLine2 = line2.isOnLine(5, -2); // false because -25(5) + 40(-2) + 30 ? 0
    System.out.println("onLine2 should be false and is " + onLine2);
  }
}