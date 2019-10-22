import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=721 lang=java
 *
 * [721] 账户合并
 *
 * https://leetcode-cn.com/problems/accounts-merge/description/
 *
 * algorithms
 * Medium (30.29%)
 * Likes:    33
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 4.1K
 * Testcase Example:  '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
 *
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称
 * (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * 
 * 
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * 
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * 
 * 例子 1:
 * 
 * 
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 *  ["John","johnnybravo@mail.com"], 
 * ["John", "johnsmith@mail.com","john_newyork@mail.com"],
 *  ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com','johnsmith@mail.com'], 
 *  ["John", "johnnybravo@mail.com"], ["Mary","mary@mail.com"]]
 * Explanation: 
 * ⁠ 第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。 
 * ⁠ 第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 * ⁠
 * 我们可以以任何顺序返回这些列表，例如答案
 * [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ⁠
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]
 * 仍然会被接受。
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 这个还好的拉。
        // 这个感觉还好的。
        // 不过itor在it的时候，不太允许删除的啊。那我就改成在另外一个新增的了，吼吼
        return AccountsMerge.solution(accounts);
    }
}
class AccountsMerge {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();  
        one.add("John");
        one.add("johnsmith@mail.com");
        one.add("john_newyork@mail.com");
        List<String> two = new ArrayList<>();  
        two.add("John");
        two.add("johnsmith@mail.com");
        two.add("john00@mail.com");
        Set<String> set = new HashSet<>();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(one);
        accounts.add(two);
        solution(accounts);
    }

    public static List<List<String>> solution(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        // 这个存的是ans的
        // 这个代码写的不好看啊。
        int index = 0;
        for(List<String> list: accounts) {
            if(list.size()<2) continue;
            String name = list.get(0);
            int tagIndex = -1;
            for(int i=1;i<list.size();i++){
                String tag = new String(name+"-"+list.get(i));
                tagIndex = Math.max(map.getOrDefault(tag, -1), tagIndex);
            }
            if(tagIndex == -1) {
                index++;
                List<String> tmp = new LinkedList<>();
                tmp.addAll(list);
                ans.add(tmp);
                for(int i=1;i<list.size();i++){
                    String tag = new String(name+"-"+list.get(i));
                    map.put(tag, index);
                }
            }else {
                // 准备合并
                Set<String> set = new HashSet<>();
                set.addAll(ans.get(tagIndex).subList(1, ans.get(tagIndex).size()));
                set.addAll(list.subList(1, list.size()));
                List<String> tmp = new LinkedList<>();
                tmp.add(list.get(0));
                tmp.addAll(tmp);
                ans.set(tagIndex, tmp);
            }
        }
        return ans;
    }
}
// @lc code=end

