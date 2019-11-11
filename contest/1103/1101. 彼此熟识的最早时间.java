class Solution1101 {
    static int[] father;
    public int earliestAcq(int[][] logs, int N) {
        father = new int[N];
        for(int i=0; i < N; i++) {
            father[i] = i;
        }
        int xx = N;
        Arrays.sort(logs,(arr1, arr2)->arr1[0] - arr2[0]);
        for(int[] log: logs) {
            int fa1 = findFather(log[1]);
            int fa2 = findFather(log[2]);
            if(fa1 != fa2) {
                xx--;
                int fa =  Math.min(log[1], log[2]);
                father[fa1] = fa2;
                if(xx == 1) return log[0];
            }
        }
        return -1;
    }
    int findFather(int n) {
        if(father[n] != n) {
            return findFather(father[n]);
        }else {
            return n;
        }
    }
}