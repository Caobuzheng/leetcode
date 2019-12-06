import java.util.*;

/**
 * S1200
 */
public class S1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<List<Integer>> ans = new LinkedList<>();

        for(int i = 2;i<arr.length;i++) {
            min = Math.min(arr[i] - arr[i-1], min);
        }
        for(int i = 1; i<arr.length;i++) {
            if((arr[i] - arr[i-1]) == min) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i-1]);
                tmp.add(arr[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}