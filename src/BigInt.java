import java.util.*;

public class BigInt {
    private ArrayList number1;
    private ArrayList number2;
    private ArrayList answer;

    //the constructor
    public BigInt(ArrayList<Integer> list1, ArrayList<Integer> list2){
        number1 = (ArrayList)list1.clone();
        number2 = (ArrayList)list2.clone();
        answer = new ArrayList<Integer>();

        //add zeros to the front to make digits line up if they have a dif number of digits
        while (number1.size() < number2.size())
            number1.add(0, 0);

        while (number2.size() < number1.size())
            number2.add(0, 0);

        //add an extra zero in front, for if the first digit of each num's addition results in a carry over
        //like with 483 + 571, need to run one more time to return 1054 instead of just 054
        number1.add(0, 0);
        number2.add(0, 0);
    }

    // clears the lists so you can try another example.
    public void clearArraylist(){
        while (!number1.isEmpty()){
            number1.remove(0);
        }
        while (!number2.isEmpty()){
            number2.remove(0);
        }
        while (!answer.isEmpty()){
            answer.remove(0);
        }
    }

    // calculates the sum of the two #’s.
    public void addNums(){
        int n1;
        int n2;
        int digitSum;
        int length = number1.size();
        int nextPos;
        int nextDigitPart;

        for (int i = length-1; i >= 0; i--) {
            n1 = (Integer)number1.get(i);
            n2 = (Integer)number2.get(i);
            digitSum = n1 + n2;

            //if carry over, ie 9+3 = 12, so keep 2 in this place, add 1 to higher place
            if (digitSum > 9){
                nextPos = i-1;
                if (nextPos < 0)
                    nextPos = 0;

                nextDigitPart = (Integer)number1.get(nextPos);
                number1.set(nextPos, nextDigitPart + 1);
                digitSum -= 10;
            }

            answer.add(0, digitSum);
        }
        //remove leading zeros
        while ((Integer)answer.get(0) == 0){
            answer.remove(0);
        }
    }
    // calculates the difference of the two #’s.
    public void subNums(){
        //subtraction needs larger num to be on top, so reassign as necessary
        ArrayList<Integer> largerNum = new ArrayList<>();
        ArrayList<Integer> smallerNum = new ArrayList<>();

        //iterate through leading zeros until finding actual start to determine which is larger...either by
        //first digit place, or if both start in same place, then by numerical comparison of the start digits.
        int multiplier = 1; //if we flip the numbers, we need to negate the result
        int d1;
        int d2;
        int m = 0;
        boolean stop = false;
        while (m < number1.size() && !stop){
            d1 = (Integer)number1.get(m);
            d2 = (Integer)number2.get(m);

            if (d1 > 0 && d2 == 0){
                largerNum = number1;
                smallerNum = number2;
                stop = true;
            } else if (d2 > 0 && d1 == 0){
                largerNum = number2;
                smallerNum = number1;
                multiplier = -1;
                stop = true;
            } else if (d1 > d2) {
                largerNum = number1;
                smallerNum = number2;
                stop = true;
            } else if (d2 > d1) {
                largerNum = number2;
                smallerNum = number1;
                multiplier = -1;
                stop = true;
            }
            m++;
        }


        int n1;
        int n2;
        int digitDif;
        int length = number1.size();

        for (int i = length-1; i >= 0; i--) {
            n1 = largerNum.get(i);
            n2 = smallerNum.get(i);

            //if we need to carry, bc difference will be negative...if possible
            if (n2 > n1 && i > 0){
                //find next digit to take 10 away from (move on to next if zero)
                int nonZeroIndex = i-1;
                while (nonZeroIndex > 0 && largerNum.get(nonZeroIndex) == 0){
                    nonZeroIndex -= 1;
                }

                //either all above digits are zero or:
                //we found it, now lets go backwards setting all zeros to 9 on the way back to i
                boolean found = largerNum.get(nonZeroIndex) > 0;
                if (found){
                    largerNum.set(nonZeroIndex, largerNum.get(nonZeroIndex) - 1);
                    int zerosIndex = nonZeroIndex + 1;
                    //then set all zeros to 9
                    while (zerosIndex < i){
                        largerNum.set(zerosIndex, 9);
                        zerosIndex++;
                    }

                    n1 += 10;
                }
            }
            digitDif = n1 - n2;

            answer.add(0, digitDif);
        }

        //remove leading zeros
        while ((Integer)answer.get(0) == 0){
            answer.remove(0);
        }

        //make first real digit of answer negative if answer should be negative
        answer.set(0, (Integer)answer.get(0) * multiplier);
    }

    // returns the answer for printing.
    public ArrayList getAnswer(){
        return answer;
    }
}
