import java.util.HashSet;
import java.util.Map;

/**
 * S156_1
 */
public class S156_1 {
    // 1207. 独一无二的出现次数
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) map.put(i, map.getOrDefault(i, 0)+1);
        Set<Integer> set = new HashSet<>();
        for(int i: map.values()) {
            if(set.contains(i)) return false;
            set.add(i);
        }
        return true;
    }
}
