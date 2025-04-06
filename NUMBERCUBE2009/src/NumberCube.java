public class NumberCube
{
  /** @return an integer value between 1 and 6, inclusive
    */
  public int toss()
  { 
    return (int) (Math.random() * 6) + 1;
  }
  
  public static int[] getCubeTosses(NumberCube cube, int numTosses){
   int[] tosses = new int[numTosses];
    for(int i = 0; i<tosses.length;i++)
      tosses[i] = cube.toss();
    return tosses;
  }

  public static int getLongestRun(int[] values){
    int inARow = 1;
    int maxInRow = 1;
    int startOfMaxInRow = -1;

    for(int i = 0; i<values.length; i++){
        if (values[i] == values[i+1]){
          inARow++;

          if(inARow > maxInRow){
            maxInRow = inARow;
            startOfMaxInRow = 1;
          }
        }
        else inARow = 1;
    }
    return startOfMaxInRow;
  }

  public static void main(String[] args)
  {
    NumberCube cube = new NumberCube();
    for (int i = 0; i < 10; i++)
      System.out.println(cube.toss());
  }
}