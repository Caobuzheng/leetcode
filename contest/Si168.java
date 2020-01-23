import java.util.*;

public class Si168 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        System.out.println(isPossibleDivide(nums, 3));
        System.out.println(isPossibleDivide(new int[]{1,2,3,4}, 3));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // 实现不想写了。还是看airflow的吧
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> list = new LinkedList<>(map.keySet());
        Collections.sort(list);
        for(int i: list) {
            int c = map.get(i);
            if(c == 0) continue;
            for(int j=1;j<k;j++) {
                int yo = i+j;
                int cc = map.getOrDefault(yo,0);
                if(cc<c) return false;
                else {
                    map.put(yo, cc-c);
                }
            }
        }
        return true;
        
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums) {
            int n = num;
            int c = 0;
            while(n>0){
                n/=10;
                c++;
            }
            if(c%2==0) count++;
        }   
        return count;
    }
}