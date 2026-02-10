import java.util.HashMap;
import java.util.Map;

public class Words {
    public static Map <Character, Integer> countWord (String text ) {

        Map<Character, Integer> wordCount = new HashMap<>();
        char [] words = text.toLowerCase().replaceAll(" ","").toCharArray();

        for(Character word : words) {

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
    
    public static void main(String[] args) {
        String input = "a aa abC aa ac abc bcd a";
        Map<Character, Integer> result = countWord(input);
        System.out.println(result);
    }
}

