import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Accepted
113/113 cases passed (158 ms)
Your runtime beats 5.18 % of java submissions
Your memory usage beats 95.17 % of java submissions (41.1 MB)
this is bad... i used to many times
/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (52.27%)
 * Likes:    142
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 26.9K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是
 * C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，
 * 所以他们三个在一个朋友圈，返回1。
 * 
 * 
 * 注意：
 * 
 * 
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        return FindCircleNum.findCircleNum(M);
    }
    
}

class FindCircleNum2 {
    public static void main(String[] args) {
        int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}; // this is 1
        System.err.println(findCircleNum(M));
        // int[][] M2 = {{1,1,0},{1,1,1},{0,1,1}};
        // System.err.println(findCircleNum(M2));
    }

    public static int findCircleNum(int[][] M) {
        int m = M.length;
        if(m==0) return 0;
        int n = M[0].length;
        if(n==0) return 0;

        for(int i=0;i<m;i++) {
            for(int j=i+1;j<n;j++) {
                if(M[i][j] == 1) {
                    add(i, j, map);
                }
            }
        }
        return ans;
    }
    public static void dfsMark(int[][] M, int m, int n) {
        for(int i =0; i<M.length;i++) {
            // 这肯定不对的。
            M[i][n] = 1;
            M[m][i] = 1;
        }
    }
}


class FindCircleNum {
    public static void main(String[] args) {
        int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}; // this is 1
        System.err.println(findCircleNum(M));
        // int[][] M2 = {{1,1,0},{1,1,1},{0,1,1}};
        // System.err.println(findCircleNum(M2));
    }
    public static int findCircleNum(int[][] M) {
        int m = M.length;
        if(m==0) return 0;
        int n = M[0].length;
        if(n==0) return 0;

        Map<Integer, IndexSet> map = new HashMap<>();

        // 这个错了的
        for(int i=0;i<m;i++) {
            for(int j=i+1;j<n;j++) {
                if(M[i][j] == 1) {
                    add(i, j, map);
                }
            }
        }
        // for(Map.Entry<Integer,IndexSet> entry : map.entrySet()) {
        //     entry.
        // }

        for(int i=0; i<m;i++) {
            add(i,i,map);
        }
        return Long.valueOf(map.values().stream().map(set->set.index).distinct().count()).intValue();
    }
    public static void add(int a, int b, Map<Integer, IndexSet> map) {
        Set<Integer> newSet = new HashSet<>();
        newSet.add(a);
        newSet.add(b);
        IndexSet indexSet = new IndexSet(Math.min(a,b));
        indexSet.set = newSet;
        if(!map.containsKey(a) && !map.containsKey(b)){
            map.put(a, indexSet);
            map.put(b, indexSet);
        }else { // 新增一个
            IndexSet more = null;
            boolean tag = false;
            if(map.containsKey(a)) {
                more = map.get(a);
            }
            if(map.containsKey(b)) {
                IndexSet more2 = map.get(b);;
                if(more != null) {
                    tag = true;
                    // 合并下
                    // 要更新下
                    more2.index = Math.min(more.index ,more2.index);
                    more2.set.addAll(more.set);
                }
                more = more2;
            }
            more.index = Math.min(more.index, Math.min(a, b));
            newSet.addAll(more.set);
            more.set = newSet;
            if(tag) {
                for(Integer i: newSet) {
                    map.put(i, more);
                }
            }else {
                map.put(a, more);
                map.put(b, more);
            }
        }
    }
}
class IndexSet {
    public Integer index;// the Min val in the Set
    public Set<Integer> set;
    public IndexSet(int index) {
        this.index = index;
    }
}
// @lc code=end
