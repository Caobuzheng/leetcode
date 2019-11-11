import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Leaderboard {
    private Map<Integer, Integer> map = new HashMap<>(); 
    // 怎么说啊，我没试过的
    public Leaderboard() {
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(pa, defaultValue))
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }
    
    // topK的话，是最好维护个那个啥的吧。还是都遍历一遍的好呢？
    public int top(int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(K);
        for(int i: map.values()) {
            queue.add(i);
        }
        int sum = 0;
        for(int i = 0;i<k;i++) {
            sum += queue.poll();
        }
        return sum;
    }
    
    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}
class Player{
    int id;
    int score;
    public Player(int id, int score){
        this.id = id;
        this.score = score;
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */