
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class Si170 {
    public static void main(String[] args) {
        String[][] watchedVideos = {{"bjwtssmu"},{"aygr","mqls"},{"vrtxa","zxqzeqy","nbpl","qnpl"},{"r","otazhu","rsf"},{"bvcca","ayyihidz","ljc","fiq","viu"}};
        int[][] friends = {{3,2,1,4},{0,4},{4,0},{0,4},{2,3,1,0}};
        int id = 3;
        int level = 1;
        List<String> list = watchedVideosByFriends(watchedVideos, friends, id, level);
        System.out.println(String.join(",", list));
        Collections.sort(list);

        System.out.println(String.join(",", list));
    }

    public static int minInsertions(String s) {
        // 最优化的问题，一般就用dp,然后看复杂度，是二维dp了。
        // dp[i][j]
    }




    /**
     * [["bjwtssmu"],["aygr","mqls"],["vrtxa","zxqzeqy","nbpl","qnpl"],["r","otazhu","rsf"],["bvcca","ayyihidz","ljc","fiq","viu"]]
[[3,2,1,4],[0,4],[4,0],[0,4],[2,3,1,0]]
3
1
     * @param watchedVideos
     * @param friends
     * @param id
     * @param level
     * @return
     */


    public static List<String> watchedVideosByFriends(String[][] watchedVideos, int[][] friends, int id, int level) {
        List<String> ans = new LinkedList<>();
        // 先遍历
        boolean[] peoples = new boolean[friends.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        peoples[id] = true;
        for(int i = 0;i<level && !queue.isEmpty();i++) {
            int size = queue.size();
            for(int j = 0;j<size;j++) {
                int friend = queue.poll();
                for(int ff: friends[friend]) {
                    if(!peoples[ff]) {
                        queue.add(ff);
                        peoples[ff] = true;
                    }
                }
            }
        }
        // 计数
        PriorityQueue<Map.Entry<String, Integer>>pq = new PriorityQueue<>((o1,o2) -> {
            // int cc = o1.getValue() - o2.getValue();
            // if(cc == 0) return o1.getKey().compareTo(o2.getKey());
            // else return cc;
            return o1.getKey().compareTo(o2.getKey());
        } );
        Map<String, Integer> map = new HashMap<>();
        while(!queue.isEmpty()) {
            int fri = queue.poll();
            for(String move: watchedVideos[fri]) {
                map.put(move, map.getOrDefault(move, 0)+1);
            }
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            pq.add(entry);
        }

        while(!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }
        return ans;
    }


    public static int[] xorQueries(int[] arr, int[][] queries) {
        for(int i=1;i<arr.length;i++) {
            arr[i] = arr[i] ^ arr[i-1];
        }
        int[] result = new int[queries.length];
        for(int i = 0;i<queries.length;i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l==0) {
                result[i] = arr[r];
            }else {
                result[i] = arr[r] ^ arr[l-1];
            }
        }
        return result;
    }


    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++) {
            int j = i+2;
            if(j<chars.length && chars[j] == '#') {
                char c = (char)((chars[i] - '0') * 10 + (chars[i+1] - '0') + 'a' - 1);
                sb.append(c);
                i+=2;
            }else {
                sb.append((char)(chars[i]-'0' + 'a' - 1));
            }
        }
        return sb.toString();
    }
}