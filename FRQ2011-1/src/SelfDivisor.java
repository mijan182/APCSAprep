public class SelfDivisor {
    public static boolean isSelfDivisor(int number){
        if (number == 0)
        return false;
    int numRemain = number;

    while (numRemain > 0){
        int digit = numRemain % 10;

        if (digit == 0 || number % digit != 0)
            return false;
        
            numRemain /= 10;
    }

    return true;
    }

public static int[] firstNumSelfDivisors (int start, int num){
    int[] selfDivisors = new int[num];

    int possible = start;
    int i = 0;

    while (i<selfDivisors.length){
        if(isSelfDivisor(possible)){
            selfDivisors[i] = possible;
            i++;
        }
        possible++;
    }
    return selfDivisors;
}

public static void main (String[] args)
  {
    System.out.println("128: " + isSelfDivisor(128));
    System.out.println("26: " + isSelfDivisor(26));
    System.out.println("120: " + isSelfDivisor(120));
    System.out.println("102: " + isSelfDivisor(102));
    for (int n : firstNumSelfDivisors(10, 3))
      System.out.print(n + " ");
    System.out.println();
  }
}

