import java.util.*;

public class Test {

    private static final Character LEFT_PAREN = '(';
    private static final Character RIGHT_PAREN = ')';
    private static final Character LEFT_BRACK = '[';
    private static final Character RIGHT_BRACK = ']';
    private static final Character LEFT_BRAC = '{';
    private static final Character RIGHT_BRAC = '}';

    public static void main(String[] args) {
        Test test = new Test();
        test.q5();
        //System.out.println(test.isBalanced(null));
    }

    boolean isBalanced(String word) {
        Character[] characters = {'(','{', ')','}'};
        Stack<Character> stack = new Stack<>();
        for (Character position : characters) {
            if (position.equals(LEFT_PAREN)) stack.push(position);
            if (position.equals(LEFT_BRAC)) stack.push(position);
            if (position.equals(LEFT_BRACK)) stack.push(position);

            if (position.equals(RIGHT_PAREN) && stack.pop() != LEFT_PAREN)
                return false;
            if (position.equals(RIGHT_BRAC) && stack.pop() != LEFT_BRAC)
                return false;
            if (position.equals(RIGHT_BRACK) && stack.pop() != LEFT_BRACK)
                return false;
            if (!stack.isEmpty())
                return false;
        }
        return true;
    }

    void randonCodes () {
        // how to create an array
        Character[] arrayChar = {'a','b'};
        // --
        Character[] array2 = new Character[10];
        array2[0] = 'a';

        String example2 = "asdfa";
        example2.toCharArray();
        // ------------
        // How to iterate over all the characters in a String
        String example = "bla bla";

        for (int x=0; x <= example.length(); x++);
    }

    //Write a Java Program to reverse a string without using String inbuilt function.

    public String reverse (String toReverse) {
        StringBuilder result = new StringBuilder();

        for (int x = toReverse.length()-1; x>=0; x--)
            result.append(toReverse.charAt(x));

        // another solution
        result = new StringBuilder(toReverse);
        result.reverse();

        return result.toString();
    }

    void q4() {
        int x = 1;
        int y = 2;
        int temp = 0 ;
        temp = x;
        x = y;
        y = temp;
    }

    void q5() {
        String phrase = "bla bla fas fadfad dsf dfdfs fas";
        String[] s = phrase.split(" ");
        TreeMap<String, Long> hashMap = new TreeMap<>();

        for (String word : s)
            if (hashMap.containsKey(word))
                hashMap.put(word, hashMap.get(word) + 1);
            else
                hashMap.put(word, 1L);

        System.out.println(hashMap.size());
    }

    void q6() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.put(1,3);
        hashMap.put(2,4);
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey());
        }

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
    }

    void q7() {
        Integer number = 7;


    }

}
