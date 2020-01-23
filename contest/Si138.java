import java.util.*;

public class Si138 {
    public static void main(String[] args) {
        int n = 10;
        int[][] connections = {{6,8},{0,4},{1,2},{5,8},{0,9},{1,8},{1,4},{4,9},{4,6},{3,7},{2,4},{3,5},{6,7},{4,5}};
        System.out.println(makeConnected(n, connections));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> ans = new LinkedList<>();
        int i = 1;
        int j = 1;
        while(true) {
            if(i>=nums1.length && j >= nums2.length) break;
            int l1 = i>=nums1.length?nums1.length:i;
            int l2 = j>=nums2.length?nums2.length:j;
            if(l1*l2 >= k) break;
            if(i>=nums1.length) {
                j++;
                continue;
            }
            if(j>= nums2.length) {
                i++;
                continue;
            }
            if(nums1[i+1]<nums2[j+1]) {
                i++;
            }else {
                j++;
            }
        }
        
        for(int p = 0; p<i;p++) {
            for(int q = 0;q<j;q++) {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(p);tmp.add(q);
                ans.add(tmp);
            }
        }
        Collections.sort(ans,(l1, l2) -> l1.get(0) + l1.get(1)  - l2.get(0) - l2.get(1));
        ans = ans.subList(0,k);
        return ans;
    }



    static int[] fa;
    public static int makeConnected(int n, int[][] connections) {
        Arrays.sort(connections, (o1,o2)->{
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }else {
                return  o2[0] - o1[0];
            }
        });
        int len = connections.length;
        if(len+1<n) return -1;
        fa = new int[n];
        for(int i = 0;i<n;i++) {
            fa[i] = i;
        }
        int ans = 0;
        for(int[] cc: connections) {
            int a = cc[0];
            int faA = getFa(a);
            int b = cc[1];
            int faB = getFa(b);
            if(a == 3 || b== 3) {
                System.out.println("yoyoyo");
            }
            if(faA != faB) {
                if(faA<faB) {
                    fa[b] = faA;
                }else {
                    fa[a] = faB;
                }
            }
        }
        // ans++;
        // 需要个，求有多少组的。
        int[] cccc = fa;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++) {
            set.add(getFa(i));
        }
        for(int i: set) {
            System.out.println(i);
        }
        return set.size()-1;
    }
    static int getFa(int i) {
        while(i != fa[i]) {
            return getFa(fa[i]);
        }
        return fa[i];
    }






    public static int[] getNoZeroIntegers(int n) {
        int nn = n;
        int a = 0;
        int more = 0;
        while(n > 1) {
            int c = n % 10;
            c+=more;
            more = 0;
            if(c == 0) {
                a=a*10+1;
                more = -1;
            }else if(c == 1){
                a = a*10+2;
                more = -1;
            }else {
                a = a*10 + 1;
            }
            n /= 10;
        }

        int b = 0;
        while(a>0) {
            b = b*10+a%10;
            a/=10;
        }

        System.out.println(b);
        System.out.println(nn-b);
        return new int[]{b, nn-b};
    }

    public static int distinctEchoSubstrings(String text) {
        Set<String>  set = new HashSet<>();
        for(int i = 0; i< text.length()-1;i++) {
            for(int j = 1;j<text.length();j++) {
                if(i+j>text.length()) break;
                int rr = i+j*2;
                if(rr > text.length()) break;
                String str = text.substring(i, i+j);
                str = str + str;
                String o = text.substring(i, rr);
                if(str.equals(o)) {
                    set.add(o);
                }
            }
        }
        return set.size();
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        // 完蛋，我想的办法是不对的。难道只能搜索？
        // 换一种思路。想到了
        if(barcodes.length<=2) return barcodes;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: barcodes) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] ans = new int[barcodes.length];
        PriorityQueue<Map.Entry<Integer, Integer>> queue = 
            new PriorityQueue<>((m1,m2)->m2.getValue() - m1.getValue());
        for(Map.Entry<Integer, Integer> e: map.entrySet()) queue.add(e);
        int index = 0;
        while(true) {
            Map.Entry<Integer, Integer> e = queue.poll();
            for(int i = 0; i< e.getValue();i++) {
                ans[index] = e.getKey();
                if(index >= ans.length) ans = 1;
            }
        }
        return ans;
    }

    public int heightChecker(int[] heights) {
        if(heights.length ==0) return 0;
        int[] more = new int[heights.length];
        for(int i = 0;i<heights.length;i++) {
            more[i] = heights[i];
        }
        Arrays.sort(more);
        int count = 0;
        for(int i = 0;i<heights.length;i++) {
            if(more[i] != heights[i]) count++;
        }
        return count;
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int count = 0;
        int max = 0;
        for(int i = 0; i< customers.length;i++) {
            if(grumpy[i] == 0) count += customers[i];
        }
        int tmp = 0;
        for(int i = 0; i<X-1;i++) {
            if(grumpy[i] == 1) {
                tmp+=customers[i];
            }
        }
        for(int i=X;i<customers.length;i++) {
            if(grumpy[i] == 1) {
                tmp += customers[i];
            }
            max = Math.max(tmp, max);
            if(grumpy[i-x] == 1) {
                tmp -= customers[i-x];
            }
        }
        max = Math.max(tmp, max);
        return count+max;
    }
}