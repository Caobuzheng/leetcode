import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Accepted 
 * @lc app=leetcode.cn id=853 lang=java
 *
 * [853] 车队
 *
 * https://leetcode-cn.com/problems/car-fleet/description/
 *
 * algorithms
 * Medium (33.48%)
 * Likes:    30
 * Dislikes: 0
 * Total Accepted:    1.8K
 * Total Submissions: 5.3K
 * Testcase Example:  '12\n[10,8,0,5,3]\n[2,4,1,1,3]'
 *
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 
 * 
 * 
 * 会有多少车队到达目的地?
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * 所有车的初始位置各不相同。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        return CarFleet.carFleet(target, position, speed);
    }
}
class CarFleet {
    public static void main(String[] args) {
        // int[] position = {10,8,0,5,3};
        int[] position = {620831,145366,229113,144305,382893,514856,171642,87230,409014,65613};
        int[] speed = {327716,69772,667805,856849,78755,606982,696937,207697,275337,290550};
        // int[] speed = {2,4,1,1,3};
        System.out.println(660732 * 409014);
        // System.out.println(carFleet(660732, position, speed));
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        if(position.length==0) return 0;
        int res = 1;
        // 进行个排序
        List<Car> list = new ArrayList<>();
        for(int i=0;i<position.length;i++) {
            list.add(new Car(position[i], speed[i]));
        }
        Collections.sort(list, (car1, car2) -> {
            return car1.position - car2.position;
        });
        // 车队第一辆车
        Car lastCar = list.get(list.size()-1);

        for(int i = list.size() -2 ;i>=0; i--) {
            Car thisCar = list.get(i);
            if( // 
            (double) (target - lastCar.position) / lastCar.speed 
                <
            (double) (target - thisCar.position) /  thisCar.speed
            ){
                res++;
                lastCar = thisCar;
            }
        }
        return res;
    }

}
class Car {
    int position;
    int speed;
    public Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
// @lc code=end

