import java.util.*;

public class BigInt {
    ArrayList number1;
    ArrayList number2;
    ArrayList answer;

    //the constructor
    public BigInt(ArrayList<Integer> list1, ArrayList<Integer> list2){
        number1 = (ArrayList)list1.clone();
        number2 = (ArrayList)list2.clone();
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

    }
    // calculates the difference of the two #’s.
    public void subNums(){

    }

    // returns the answer for printing.
    public ArrayList getAnswer(){
        return answer;
    }
}
