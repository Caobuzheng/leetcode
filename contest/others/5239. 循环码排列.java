import java.util.ArrayList;
import java.util.List;

class Solution5239 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = build(n);
        List<Integer> res = new ArrayList<>(list.size());
        int i = 0;
        for(;i<list.size();i++) {
            if(list.get(i).equals(start)) {
                break;
            }
        }
        res.addAll(list.subList(i, list.size()));
        res.addAll(list.subList(0, i));
        return res;
    }

    private List<Integer> build(int n){
        if(n==1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> old = build(n-1);
        int size = old.size();
        List<Integer> res = new ArrayList<>(size * 2);
        int m = 1;
        while(n-->1) {
            m*=2;
        }
        res.addAll(old);

        for(int i=1;i<=old.size();i++) {
            res.add(res.get(size-i)+m);
        }
        return res;
    }
}