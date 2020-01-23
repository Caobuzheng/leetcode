/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */
import java.util.*;
// @lc code=start
class WordDictionary {
    Set<String> set;
    /** Initialize your data structure here. */
    public WordDictionary() {
        set = new HashSet<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        // for()
        // 就是个字典树，然后搜索的方式不一样了
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
    }
}
class TrieTree{
    Character val;
    Boolean isend;
    List<TrieTree> children;

    public TrieTree(String str) {

    }
    public void add(String str) {
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

