import java.util.*;
public class Si137{
    public static void main(String[] args) {
        System.out.println("yo");
    }


    /**
     * 输入：[2,7,4,1,8,1]
        输出：1
        解释：
        组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
        组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
        组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
        组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
        记忆会的xx的么？
        30 * 29 * 28 * 27.
     * @param stones
     * @return
     */
    int min;
    Set<String> set;
    public int lastStoneWeightII(int[] stones) {
        min = Integer.MAX_VALUE;
        set = new HashSet();
        lastStoneWeightIIHelp(stones);
        return min;
    }
    public void lastStoneWeightIIHelp(int[] stones) {
        if(stones.length == 0) {
            min = 0;
            return;
        }
        if(stones.length == 1) {
            min = Math.min(min, stones[0]);
        }
        Arrays.sort(stones);
        String str = buildStr(stones);
        if(set.contains(str)) return;
        set.add(str);

        for(int i = 0; i<stones.length-1;i++) {
            for(int j = i+1; j< stones.length;j++) {
                if(stones[i] == stones[j]) {
                    int[] next = new int[stones.length-2];
                    for(int k =0,index =0;k<stones.length;k++) {
                        if(k!=i && k!=j) {
                            next[index++] = stones[k];
                        }
                    }
                    lastStoneWeightIIHelp(next);
                }else {
                    int[] next = new int[stones.length-1];
                    int index = 0;
                    for(int k =0;k<stones.length;k++) {
                        if(k!=i && k!=j) {
                            next[index++] = stones[k];
                        }
                    }
                    next[index] = stones[j] - stones[i];
                    lastStoneWeightIIHelp(next);
                }
            }
        }
    }
    String buildStr(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i : nums) {
            sb.append("_" + i);
        }
        return sb.toString();
    }



    public int longestStrChain(String[] words) {
        Map<Integer, Map<String, Integer>> map = new HashMap();
        for(String word: words) {
            int len = word.length();
            if(!map.containsKey(len)) {
                map.put(len, new HashMap<>());
            }
            map.get(len).put(word, 1);
        }

        int max = 1;
        for(int i = 1; i<16;i++) {
            if(!map.containsKey(i) || !map.containsKey(i+1)) continue;
            for(Map.Entry<String, Integer> ci: map.get(i).entrySet()) {
                for(Map.Entry<String, Integer> cj: map.get(i+1).entrySet()) {
                    if(bingo(ci.getKey(), cj.getKey())) {
                        int val = Math.max(ci.getValue()+1, cj.getValue());
                        map.get(i+1).put(cj.getKey(), val);
                        max = Math.max(max, val);
                    }
                }
            }
        }
        return max;
    }

    boolean bingo(String str1, String str2) {
        if(str2.length() - str1.length() != 1) {
            return false;
        }

        int[] count = new int[26];
        for(char c: str2.toCharArray()) {
            count[c-'a']++;
        }
        for(char c: str1.toCharArray()) {
            count[c-'a']--;
            if(count[c-'a'] <0) return false;
        }
        return true;
    }

    public String removeDuplicates(String S) {
        String s = S;
        boolean tag = true;

        while(tag) {
            tag = false;
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for(int i = 0;i<chars.length-1;i++) {
                if(chars[i] != chars[i+1]) {
                    sb.append(chars[i]);
                }else {
                    i++;
                    tag = true;
                }
            }
            s = sb.toString();
        }
        return s;
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i: stones) queue.add(i);
        while(queue.size()>1) {
            int x = queue.poll();
            int y = queue.poll();
            if(x > y) {
                queue.add(x-y);
            }
        }
        if(queue.size() ==0) return 0;
        return queue.poll();
    }
}