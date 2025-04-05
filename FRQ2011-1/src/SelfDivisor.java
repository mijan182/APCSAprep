public class SelfDivisor {

    public static boolean isSelfDivisor(int number) {
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || number % digit != 0) {
                return false;
            }
            temp /= 10;
        }

        return true;
    }

    public static int[] firstNumSelfDivisors(int start, int num) {
        int[] result = new int[num];
        int count = 0;
        int current = start;

        while (count < num) {
            if (isSelfDivisor(current)) {
                result[count] = current;
                count++;
            }
            current++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = firstNumSelfDivisors(10, 3);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        // Output should be: 11 12 15
    }
}
