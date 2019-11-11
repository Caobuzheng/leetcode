import java.util.*;
import java.util.Map;
class Solution1153 {
    // 怎么边
    public boolean canConvert(String str1, String str2) {
        Map<Charater, Integer> m1 = new HashMap<>();
        Map<Charater, Integer> m2 = new HashMap<>();
       
        for(char c: str1.toCharArray()) m1.put(c, m1.getOrDefault(c,0)+1);
        for(char c: str2.toCharArray()) m2.put(c, m2.getOrDefault(c,0)+1);
        // 然后再对m1 m2的Integer进行count。
        Map<Integer, Integer> i1 = new HashMap<>();
        Map<Integer, Integer> i2 = new HashMap<>();
        for(int i:  m1.values()) i1.put(i, i1.getOrDefault(i, 0)+1);
        for(int i:  m2.values()) i2.put(i, i2.getOrDefault(i, 0)+1);
        // 接下来就是01背包的问题了吧。
        // 这种背包的问题。我是不会的
        return false;
    }
}