import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution5240 {
    public static void main(String[] args) {
        String[] arr = {"un","iq","ue"}; // 4
        // System.out.println(maxLength(Arrays.asList(arr)));;
        String[] arr1 = {"cha","r","act","ers"}; //6
        // System.out.println(maxLength(Arrays.asList(arr1)));;
        String[] arr2 = {"a","abc"}; //0
        System.out.println(maxLength(Arrays.asList(arr2)));;
    }
    /**
     * 1 <= arr.length <= 16
        1 <= arr[i].length <= 26
        arr[i] 中只含有小写英文字母
     */
    static int ans = 0;
    public static int maxLength(List<String> arr) {
        ans = 0;
        List<boolean[]> list = new LinkedList<>();
        for(String str : arr){
            boolean[] tmp = new boolean[26];
            boolean tag = true;
            for(char c: str.toCharArray()) {
                if(tmp[c-'a']) {
                    tag = false;
                    break;
                }
                tmp[c-'a'] = true;
            }
            if(tag){
                list.add(tmp);
            }
        }
        if(list.size() == 0) return 0;
        boolean[] mem = new boolean[26];
        for(int i = 0;i<list.size();i++) {
            helper(list, i, mem, 0);   
        }
        return ans;
    }
    private static void helper(List<boolean[]> arr, int index, boolean[] mem, int count) {
        boolean[] test = arr.get(index);
        for(int i = 0; i<mem.length;i++) {
            if(test[i] && mem[i]) return; 
        }
        
        int c = count;
        for(int i = 0;i<mem.length;i++) {
            if(test[i]) {
                c++;
                mem[i] = true;
            }
        }
        ans = Math.max(c, ans);

        // 
        for(int j = index; j<arr.size()-1; j++) {
            helper(arr, j+1, mem, c);
        }

        for(int i = 0;i<mem.length;i++) {
            if(test[i]){
                mem[i] = false;
            }
        }
    }
}