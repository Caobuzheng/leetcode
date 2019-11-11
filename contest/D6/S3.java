import java.util.*;

// 这道题没有ac。确实是实在太恶心了的。
// 我好奇daodao是怎么去ac这道题的

class Solution1152 {
    public static void main(String[] args) {
        String[] username = {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
        int[] timestamp = {436363475,710406388,386655081,797150921};
        String[] website = {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
        // oz wnaaxbfhxp mryxsjc wlarkzzqht;
        // 并非连续的哈。
        // ["oz","mryxsjc","wlarkzzqht"]
        String str = String.join(",", mostVisitedPattern(username, timestamp, website));
        System.out.println(str);
    }
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        String lastUser = null;
        Pv[] pvs = new Pv[username.length];
        for (int i = 0; i < username.length; i++) {
            pvs[i] = new Pv(username[i], timestamp[i], website[i]);
        }

        Arrays.sort(pvs, (p1, p2) -> {
            int strCompare = p1.user.compareTo(p2.user);
            if (strCompare == 0)
                return p1.ts - p2.ts;
            else
                return strCompare;
        });
       
        int count = 1;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pvs.length; i++) {
            if (!pvs[i].user.equals(lastUser)) {
                count = 1;
                lastUser = pvs[i].user;
            } else {
                count++;
                if (count >= 3) {
                    String key = pvs[i - 2].website + "_010_" + pvs[i - 1].website + "_010_" + pvs[i].website;
                    if (!map.containsKey(key)) {
                        map.put(key, new LinkedList());
                    }
                    map.get(key).add(i - 2);
                }
            }
        }
        int max = 0;
        String[] strs = new String[3];
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            if (size > max) {
                max = size;
                strs = entry.getKey().split("_010_");
            } else if (size == max) {
                String[] strs2 = entry.getKey().split("_010_");
                int c1 = strs[0].compareTo(strs2[0]);
                int c2 = strs[1].compareTo(strs2[1]);
                int c3 = strs[2].compareTo(strs2[2]);
                if(c1>0 || (c1==0 && c2>0) || (c1==0 &&c2==0&&c2>0) ) {
                    strs = strs2;
                }
            }
        }
        List<String> ans = new ArrayList<>(3);
        for (String str : strs)
            ans.add(str);
        String str = String.join(",", ans);
        System.out.println(str);
        return ans;
    }
}

class Pv {
    String user;
    int ts;
    String website;

    public Pv(String user, int ts, String website) {
        this.user = user;
        this.ts = ts;
        this.website = website;
    }
}

// 大致的思路都差不多。不过这个题就是恶心系列的。
class Solution1152Copy {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> res = new ArrayList<>();
        int n=username.length;
        Set<String> users = new HashSet<>();
        for(String user : username) users.add(user);
        List<Set<String>> visited = new ArrayList<>();
        for(String user: users){
            visited.add(visit(user, username, timestamp, website));
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        for(Set<String> set : visited){
            for(String u: set){
                map.put(u, map.getOrDefault(u, 0)+1);
            }
        }
        int max = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()>max) {
                max = entry.getValue();
                res = new ArrayList<>();
                for(String s : entry.getKey().split(",")){
                    if(s.length()!=0) res.add(s);
                }
            }
        }
        return res;
    }
    
    private Set<String> visit(String user, String[] username, int[] timestamp, String[] website){
        PriorityQueue<String[]> q = new PriorityQueue<>((a,b)->Integer.valueOf(a[0])-Integer.valueOf(b[0]));
        for(int i=0; i<username.length; i++){
            if(!user.equals(username[i])) continue;
            q.offer(new String[]{String.valueOf(timestamp[i]), website[i]});
        }
        Set<String> one=new HashSet<>(), two=new HashSet<>(), res=new HashSet<>();
        while(!q.isEmpty()){
            String cur = q.poll()[1];
            for(String t : two) res.add(t+","+cur);
            for(String o : one) two.add(o+","+cur);
            one.add(cur);
        }
        return res;
    }
}