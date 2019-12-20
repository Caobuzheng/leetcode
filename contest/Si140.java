import java.util.*;
class Si140 {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
    }

    static Set<String> set;
    public static int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        set = new HashSet<>();
        yo(chars, 0, "");
        return set.size();
    }
    public static void yo(char[] chars,int count, String more) {
        if(count >= chars.length) return;
        for(int i = 0; i<chars.length;i++) {
            if(chars[i] != ' '){
                char c = chars[i];
                String str = more + c;
                chars[i] = ' ';
                set.add(str);
                yo(chars, count+1, str);
                chars[i] = c;
            }
        }
    }



    public static String smallestSubsequence(String text) {
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[] max = new int[26];
        Arrays.fill(max, Integer.MIN_VALUE);
        char[] chars = text.toCharArray();
        for(int i = 0;i<chars.length;i++) {
            max[chars[i] - 'a'] = i;
            min[chars[i] - 'a'] = Math.min( min[chars[i] - 'a'], i);
        }

        for(int i = 0;i<26;i++) {
            if(min[i] < text.length() ) {
                boolean find = true;
                for(int j = 0;j<26;j++) {
                    if(max[j] >=0 && min[i] > max[j]) {
                        find = false;
                    }
                }
                if(find) {
                    return (char)(i+'a') + smallestSubsequence(build(text, min[i]));
                }
            }
         
        }
        return text;
    }

    public static String build(String str, int index) {
        StringBuilder sb = new StringBuilder();
        char c = str.charAt(index);
        for(int i =index+1;i<str.length();i++) {
            if(str.charAt(i) != c) sb.append(str.charAt(i));
        }
        return sb.toString();
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    Map<TreeNode, Integer>  map;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        map = new HashMap<>();
        int rootVal = getMax(root);
        if(rootVal<limit) return null;
        for(Map.Entry<TreeNode, Integer> entrt :map.entrySet()){
            System.out.println(entrt.getKey().val +"   " + entrt.getValue());
        }
        test(root, 0, limit);
        return root;
    }
    void test(TreeNode node, int more, int limit) {
        int val = node.val + more;
        if(node.left != null) {
            if(map.get(node.left) + val < limit) {
                node.left = null;
            }else {
                test(node.left, val, limit);
            }
        }
        if(node.right != null) {
            if(map.get(node.right) + val < limit) {
                node.right = null;
            }else {
                test(node.right, val, limit);
            }
        }
    }

    Integer getMax(TreeNode node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }
        int val = node.val;
        int left = 0;
        int right = 0;
        if(node.left != null) {
            left = getMax(node.left);
        }
        if(node.right != null) {
            right = getMax(node.right);
        }
        val = val + Math.max(right,left);
        map.put(node, val);
        return val;
    }

    
    // dp的吧

    public String[] findOcurrences(String text, String first, String second) {
        String[] splits = text.split(" ");
        List<String> list = new ArrayList();
        for(int i =0;i<splits.length-2;i++) {
            if(splits[i].equals(first) && splits[i+1].equals(second)) list.add(splits[i+2]);
        }
        String[] ans = new String[list.size()];
        for(int i = 0;i<ans.length;i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}