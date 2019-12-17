/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length()-9;i++) {
            String str = s.substring(i, i+10);
            if(!map.containsKey(str)) map.put(str, 1);
            else {
                int c = map.get(str);
                if(c == 1) res.add(str);
                map.put(str, c+1);
            }
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        int[] num = new int[1 << 20];
        int k = (1 << 18) - 1, key = 0;
        for (int i = 0; i < s.length(); i++) {
            key <<= 2;
            key += getValue(s.charAt(i));
            if (i >= 9) {
                if (num[key] == 1) {
                    num[key]++;
                    list.add(s.substring(i - 9, i + 1));
                }
                else num[key]++;
                key &= k;
            }
        }
        return list;
    }

    private int getValue(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                throw new IllegalArgumentException("Illegal character");
        }
    }
}

// @lc code=end

