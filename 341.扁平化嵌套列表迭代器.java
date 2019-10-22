import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 * 
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

列表中的项或者为一个整数，或者是另一个列表。
 * 输入: [[1,1],2,[1,1]]
输出: [1,1,2,1,1]
解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
示例 2:

输入: [1,[4,[6]]]
输出: [1,4,6]
解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class NestedIterator implements Iterator<Integer> {
    // Lets Roll.这个题是不错的噢。
    Stack<Index> stack = new Stack<>();

    class Index {
        public Integer index;
        public List<NestedInteger> list;
        // Index 是在第几个上？这个可能是个List的吧？
        // index = 0;
        public Index(Integer index, List<NestedInteger> list) {
            this.index = index;
            this.list = list;
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        // 最牛逼的方法是，在这里就把整个List处理成个
        stack.push(new Index(0, nestedList));
        hasNext();
    }

    @Override
    public Integer next() {
        // 我这里认为那个啥
        // 这里处理好了的，就是stack的各种应用的呗
        if(hasNext()) {
            
        }

    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            Index tmp = stack.pop();
            // 这个嵌套的好恶心的啊。
            if(tmp.index<tmp.list.size()) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

