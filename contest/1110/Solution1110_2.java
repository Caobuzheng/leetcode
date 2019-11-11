import java.util.ArrayList;

/**
 * Solution1110_2
 */
public class Solution1110_2 {
    public static void main(String[] args) {
       
        int[] colsum = {2,1,2,0,1,0,1,2,0,1};

    }
    /**
 1 <= colsum.length <= 10^5
0 <= upper, lower <= colsum.length
0 <= colsum[i] <= 2
// colsum 分离啊成两个。第一个的
2,1,2,0,1,0,1,2,0,1
1 0 1 0 1 0 1 1 0 0
1 1 1 0 0 0 0 1 0 1
     */

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>(2);
        int count = 0;
        for(int i: colsum) count+=i;
        if(count != upper+lower) return ans;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i:colsum) if( i == 2) lower--; // 2 

        for(int i: colsum) {
            if(i == 2){
                list1.add(1);
                list2.add(1);
            }else if(i == 0) {
                list1.add(0);
                list2.add(0);
            }else {
                if(lower-->0) {
                    list1.add(1);
                    list2.add(0);
                }else {
                    list2.add(1);
                    list1.add(0);
                }
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}