/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start

import java.util.*;
import java.util.concurrent.BlockingDeque;
class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, 3);  
        System.out.println(cache.get(1));  // 该是2在，1不再
        System.out.println(cache.get(2));  
        System.out.println(cache.get(3));  
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));  
        System.out.println(cache.get(3));  
        System.out.println(cache.get(4));  
    }
    Map<Integer, Integer> map;
    SortedMap<Integer, Integer> sMap;
    int count;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        // treeMap是根据
        sMap = new TreeMap<Integer, Integer>((o1,o2)->o2-o1);
        count = 0;
        size = capacity;
    }
    
    public int get(int key) {
        count++;
        if(map.containsKey(key)) {
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        count++;
        int[] use = {key, count};
        if(!map.containsKey(key) && map.size() == size) {
            while(!queue.isEmpty()) {
                
                int tmp = queue.poll();
                if(map.containsKey(tmp)) {
                    map.remove(tmp);
                    break;
                }
            }
        }else {
            queue.addLast(key);
            map.put(key, value);
        }
    }
}
class TT {
    Integer k;
    Integer v;
    Integer t;
    @Override
    public int hashCode() {
        return k.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return ((TT)obj).k.equals(this.k);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

