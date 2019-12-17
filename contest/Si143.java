import java.util.Arrays;

/**
 * Si143
 */
public class Si143 {
    public static void main(String[] args) {
        Si143 si = new Si143();
        for(int i:  si.distributeCandies(60, 4) ) System.out.println(i);
        // [15,18,15,12]
        // 4
        // 8
        // 12
        // 没有18啊。
        // 1 2 3 4
        // 6 8 10 12
        // 15 18 21 24

        // for(int i:  si.distributeCandies(10, 3) ) System.out.println(i);
    }
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int sum = 0;
        int count = 0;
        while(true) {
            int num_count = num_people * count;
            sum = (1 + num_count) * num_count / 2;
            if(sum>candies) break;
            count++;
        }
        count--;
        if(count>0) {
            for(int i = 0;i<num_people;i++) {
                // 1
                // 4 -> 6
                ans[i] = (i+1)*count + (count-1) * count * num_people /2;
            }
            int num_count = num_people * count;
            candies-=((1 + num_count) * num_count / 2);
        }

        int next = count*num_people+1;
        for(int i = 0;i<num_people && candies>0;i++,next++) {
            if(candies>next) {
                ans[i] += next;
            }else {
                ans[i] += candies;
            }
            candies-=next;
        }
        return ans;
    }
}