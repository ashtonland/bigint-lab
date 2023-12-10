import java.util.ArrayList;
import java.util.Scanner;

public class BigIntDriver {
    public static void main(String[] args) {
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();

        String input;
        Scanner fina = new Scanner(System.in);

        //read input and store in arraylists
        for (int j = 0; j < 2; j++) {
            System.out.println("Enter a number");
            input = fina.nextLine();

            for (int i = 0; i < input.length(); i++) {
                int digit = Integer.parseInt(input.substring(i, i+1));
                if (j == 0)
                    num1.add(digit);
                else
                    num2.add(digit);
            }
        }

        System.out.println(num1);
        System.out.println(num2);

        BigInt BigInteger = new BigInt(num1, num2);
        BigInteger.subNums();
        System.out.println(BigInteger.getAnswer());
    }
}