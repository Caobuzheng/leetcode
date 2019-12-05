import java.util.*;

/**
 * Hash_Table
 */
public class Hash_Table {
    public static void main(String[] args) {
        Hash_Table s = new Hash_Table();
        char[][] chars = {};
        s.isValidSudoku(chars);
    }

    // 652. 寻找重复的子树
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 这个题是挺好的。
    }

    // 36 有效的数独
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> mMap = new HashMap<>();
        Map<Integer, Set<Integer>> nMap = new HashMap<>();
        Map<Integer, Set<Integer>> oMap = new HashMap<>();
        for(int i=0;i<board.length;i++) {
            for(int j = 0;j<board[0].length;j++) {
                int o = toO(i, j);
                char c = board[i][j];
                if(c == '.') continue;
                int val = c - '0';
                if(!(help(i, val, mMap) && help(j, val, nMap)  && help(o, val, oMap))) return false;
            }
        }
        return true;
    }

    private Integer toO(int i , int j) {
        return i/3*3+j/3;
    }
    private boolean help(int key, int val, Map<Integer, Set<Integer>> map) {
        if(!map.containsKey(key)) map.put(key, new HashSet<>());
        if(map.get(key).contains(val)) return false;
        map.get(key).add(val);
        return true;
    }

    // 249. 移位字符串分组
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strings) {
            String countStr = str2Count(str);
            if(!map.containsKey(countStr)) {
                map.put(countStr, new LinkedList<>());
            }
            map.get(countStr).add(str);
        }
        List<List<String>> ans = new LinkedList<>();
        for(List<String> list: map.values()) {
            ans.add(list);
        }
        return ans;
    }
    private String str2Count(String str) {
        if(str.length() == 0 ) return "";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for(int i = 1;i<chars.length;i++) {
            sb.append("_" + (chars[i] - chars[i-1] + 26) % 26);
        }
        return sb.toString();
    }
}