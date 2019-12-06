import java.util.*;

class BFS {
    
    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }

    // 752 打开转盘锁
    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String bad: deadends) set.add(bad);
        String origin = "0000";
        if(set.contains(origin)) return -1;
        set.add(origin);
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        if(origin.equals(target)) return 0;
        queue.add(origin);
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String str = queue.poll();
                for(int k = 0;k<4;k++){
                    char[] chars = str.toCharArray();
                    chars[k]= (char)('0' + (chars[k] - '0' - 1 + 10) %10);
                    String newStr = new String(chars);
                    if(!set.contains(newStr)){
                        set.add(newStr);
                        if(newStr.equals(target)) return count;
                        queue.add(newStr);
                    }
                    chars[k]= (char)('0' + (chars[k] - '0' + 2 + 10) %10);
                    newStr = new String(chars);
                    if(!set.contains(newStr)){
                        set.add(newStr);
                        if(newStr.equals(target)) return count;
                        queue.add(newStr);
                    }
                }
            }
        }
        return -1;
    }


    // 200 岛屿数量
    public int numIslands(char[][] grid) {
        // 这个题，不太习惯用那个bfs。
    }
    // 286 墙与门
    static int door = 0;
    static int wall = -1;
    static int space = 2147483647;
    static final int[][] gos = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<rooms.length;i++) {
            for(int j = 0; j<rooms[i].length;j++) {
                if(rooms[i][j] == door) {
                    int[] add = {i, j};
                    queue.add(add);
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            for(int[] go: gos) {
                
                int x = xy[0] + go[0];
                int y = xy[1] + go[1];
                if(x>=0 && x<rooms.length && y>=0 && y < rooms[0].length){
                    if(rooms[x][y] == space) {
                        rooms[x][y] = rooms[xy[0]][xy[1]] + 1;
                        int[] add = {x, y};
                        queue.add(add);
                    }
                }
            }
        }
    }
    // end of 286 墙与门
}