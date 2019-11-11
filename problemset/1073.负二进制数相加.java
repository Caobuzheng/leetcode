import java.util.LinkedList;
import java.util.List;

/*
 * Accepted
 * @lc app=leetcode.cn id=1073 lang=java
 *
 * [1073] 负二进制数相加
 *
 * https://leetcode-cn.com/problems/adding-two-negabinary-numbers/description/
 *
 * algorithms
 * Medium (28.29%)
 * Likes:    4
 * Dislikes: 0
 * Total Accepted:    707
 * Total Submissions: 2.5K
 * Testcase Example:  '[1,1,1,1,1]\n[1,0,1]'
 *
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * 
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3
 * + (-2)^2 + (-2)^0 = -3。数组形式 的数字也同样不含前导零：以 arr 为例，这意味着要么 arr == [0]，要么 arr[0]
 * == 1。
 * 
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 和 arr2 都不含前导零
 * arr1[i] 为 0 或 1
 * arr2[i] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        return AddNegabinary.addNegabinary(arr1, arr2);
    }
}

class AddNegabinary {
    public static void main(String[] args) {
        int[] arr1 = {0}; // -1
        int[] arr2 = {0}; // -1 -2
        System.err.println("yoyo");
        for(int i: addNegabinary(arr1, arr2)) {
            System.out.print(i);
        }
    }
    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length) return addNegabinary(arr2, arr1);
        if(arr1.length == 0) return arr2; // 直接不用计算了的。
        // 然后让两个表一样长。
        int[] b = arr2; 
        int[] a = new int[arr2.length]; //多余的copy
        for(int i =1 ; i<= arr1.length; i++) {
            a[a.length-i] = arr1[arr1.length-i];
        }
        int more = 0;
        for(int i=a.length-1;i>=0;i--) {
            int sum = a[i] + b[i] - more;
            if(sum == 1) {
                a[i] = 1;
                more = 0;
            }else if(sum == -1) {
                more = -1;
                a[i] = 1;
            }else if(sum == 2) {
                a[i] = 0;
                more = 1; // 这个对的。
            }else if(sum == 3) {
                more = 1; // 这个还难。
                a[i] = 1;
            }else {
                a[i] = 0;
                more = 0;
            }
        }
        List<Integer> list = new LinkedList<>();
        int i = 0 ;
        if(more == 0 ) {
            while(i<a.length-1 && a[i] ==0) i++;
        }else if(more == 1) {
            list.add(1);
            list.add(1);
        }else {
            list.add(1);
        }
        while(i<a.length) {
            list.add(a[i++]);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();   
    }
}
// @lc code=end

