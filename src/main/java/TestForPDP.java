import java.util.*;

public class TestForPDP {

    public static Map<Integer,Integer> testMap(Map<Integer,Integer> numbers) {
        Collection<Integer> values = numbers.values();
        List<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);
        Map<Integer, Integer> result = new LinkedHashMap<>();

        for (Integer value : sortedValues) {
            for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
                if (entry.getValue().equals(value)) {
                    result.put(value, entry.getKey());
                    break;
                }
            }
        }
        return result;
    }

        public static void main (String[]args){
            Map<Integer, Integer> old = new HashMap<>();
            old.put(5, 1);
            old.put(10, 3);
            old.put(50, 4);
            old.put(70, 2);


            Map<Integer,Integer> test = testMap(old);
            System.out.println(test);
    }
}
