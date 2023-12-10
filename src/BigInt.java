import java.util.*;

public class BigInt {
    ArrayList number1;
    ArrayList number2;
    ArrayList answer;

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
    }
    // calculates the difference of the two #’s.
    public void subNums(){

    }

    // returns the answer for printing.
    public ArrayList getAnswer(){
        return answer;
    }
}
