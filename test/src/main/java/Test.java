import java.util.*;

public class Test {

    public static void main(String[] args) {

        String phrase = "as saçdlfk~asç blsk ~çasl da~ç as as";

        String[] s = phrase.split(" ");

        Map<String, Integer> x = new TreeMap<>();

        Arrays.asList(s).forEach(word-> {
            if (x.containsKey(word))
                x.put(word,x.get(word)+1);
            else
                x.put(word,1);
        });

        System.out.println(x);

    }


}
