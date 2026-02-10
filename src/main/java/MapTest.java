import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static Map<Integer, Integer> mergeMaps(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key1 = entry.getKey();
            Integer value1 = entry.getValue();

            if (map2.containsKey(value1)) {

                Integer value2 = map2.get(value1);
                result.put(key1, value2);
            }
        }

        return result;
    }

        public static void main (String[]args) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();

            // Пример 1
            map1.put(1, 5);
            map1.put(2, 7);
            map1.put(3, 8);
            map1.put(4, 9);

            map2.put(5, 10);
            map2.put(7, 15);
            map2.put(8, 12);
            map2.put(9, 50);

            Map<Integer, Integer> result = mergeMaps(map1, map2);
            System.out.println(result);
        }
    }

