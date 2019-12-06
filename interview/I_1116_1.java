import java.util.Deque;
import java.util.Queue;

/**
 * I1116_1
 */

class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], 
        the second is at [1,0]. */
    Deque<int[]> queue;
    int score;
    int[][] box;
    int[][] food;
    int foodIndex;
    public SnakeGame(int width, int height, int[][] food) {
        queue = new LinkedList<>();
        int[] init = {0,0};
        queue.add(init);
        score = 0;
        box = new int[height][width];
        box[0][0] = 1;
        this.food = food;
        foodIndex = 0;
    }
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = queue.peekFirst();
        int[] maomao = new int[2];
        if(direction.equals("U")) {
            maomao[0]-=1;
        } else if(direction.equals("L")) {
            maomao[1]-=1;
        }else if(direction.equals("R")) {
            maomao[1]+=1;
        }else maomao[0]+=1;
        maomao[0] = head[0] + maomao[0];
        maomao[1] = head[1] + maomao[1];
        if(maomao[0] < 0 || maomao[0] >= box.length) return -1;
        else if(maomao[1] < 0 || maomao[1] >= box[0].length) return -1;
        else if(maomao[head[0]][maomao[1]] == 1) return -1;
        queue.addFirst(maomao);
        box[maomao[0]][maomao[1]] = 1;
        if(food[index][0] == maomao[0] && food[index][1] == maomao[1]) {
            index++;
        }else {
            int[] tail = queue.pollLast();
            box[tail[0]][tail[1]] = 0;
        }
        return index;
    }
}

public class I1116_1 {
    public static void main(String[] args) {
    }

    // 简单的swap。
    public ListNode swapPairs(ListNode head) {
        return swapPairsK(head, 2);
    }

    public ListNode swapPairsK(ListNode head , int k) {
        // lets fuck this. yo.这个确实是写过的。而且是我做出来的第一个hard的吧。还是需要
        return null;
    }

    public int compress(char[] chars) {
        int index = 0;
        int count = 1;
        char c = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(c== chars[i]) count++;
            else {
                chars[index++] = c;
                if(count != 1) {
                    String str = ""+count;
                    for(int j = 0; j < str.length(); j++) {
                        chars[index++] = str.charAt(j);
                    }
                }
                c = chars[i];
                count = 1;
            }
        }
        chars[index++] = c;
        if(count != 1) {
            String str = ""+count;
            for(int j = 0; j < str.length(); j++) {
                chars[index++] = str.charAt(j);
            }
        }
        return index;
    }
    
}