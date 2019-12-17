/**
 * Si166
 */
import java.util.*;
public class Si166 {
/**
 * [

549
 */

    public static void main(String[] args) {
        Si166 s = new Si166();
        int[][] mat = {{1,0,0},{1,0,0}};
        System.out.println(s.minFlips(mat));
    }
    
    int[][] gos = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean find;
    public int minFlips(int[][] mat) {
        find = false;
        int count = 0;
        Set<String> set = new HashSet();
        String originStr = buildStr(mat);
        set.add(originStr);
        if(find) return count;
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(mat);
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int k = 0;k<size;k++) {
                int[][] one = queue.poll();
                for(int i =0;i<one.length;i++) {
                    for(int j=0;j<one[0].length;j++) {
                        int[][] copy = copy(one, i, j);
                        String str = buildStr(copy);
                        if(find) return count;
                        if(!set.contains(str)) {
                            set.add(str);
                            queue.add(copy);
                        }
                    }
                }
            }
        }
        return -1;
    }

    int[][] copy(int[][] mat, int x, int y) {
        int[][] copy = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++) {
            for(int j = 0;j<mat[0].length;j++) {
                copy[i][j] = mat[i][j];
            }
        }
        for(int[] xy: gos){
            int xx = x+xy[0];
            int yy = y+xy[1];
            if(xx >= 0 && xx < mat.length && yy>=0 && yy<mat[0].length) {
                copy[xx][yy] = 1 - copy[xx][yy];
            }
        }
        return copy;
    }

    String buildStr(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        boolean tag = true;
        for(int[] ii:mat) for(int i: ii) {
            if(i == 1) tag = false;
            sb.append(i);
        }
        find = tag;
        return sb.toString();
    }
   
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int l = 1;
        int r = nums[nums.length-1];
        int min = r;
        while(l<=r) {
            int mid = (l+r) / 2;
            int x = getX(nums, mid);
            if(x <= threshold) {
                min = Math.min(min, mid);
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return min;
    }
    int getX(int[] nums, int t) {
        int sum = 0;
        for(int i: nums) {
            sum+=Math.floorDiv(i+t-1, t);
        }
        return sum;
    }


    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int cheng = 0;
        while(n>0) {
            int x = n%10;
            cheng = cheng * 10 + x;
            sum+=x;
            n/=10;
        }
        return cheng-sum;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new LinkedList<>();
        for(int i =0;i<groupSizes.length;i++) {
            if(!map.containsKey(groupSizes[i])) map.put(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }

        for(int i: map.keySet()) {
            List<Integer> list = map.get(i);
            int index = 0;
            for(int j = 0; j<list.size()/i;j++) {
                List<Integer> rr = new LinkedList<>();
                for(int k = 0;k<i;k++) {
                    rr.add(list.get(index++));
                }
                ans.add(rr);
            }
        }
        return ans;

    }
}