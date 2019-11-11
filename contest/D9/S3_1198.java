class Solution1198 {
    // 大概知道了。得这么写。
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
        System.out.println(smallestCommonElement(mat));
    }
    public static int smallestCommonElement(int[][] mat) {
        int[] indexs = new int[mat.length];
        int min = mat[0][0];
        boolean find = false;
        while(!find) {
            find = true;
            int nextMin = min;
            // 如果没小于这个的话，就要找到>=min的
            for(int i =0; i< mat.length;i++) {
                if(mat[i][indexs[i]] < min) {
                    while(indexs[i] < mat[i].length && mat[i][indexs[i]]<min){
                        indexs[i]++;
                    }
                }
                if(indexs[i] >= mat[i].length) return -1;
                if(mat[i][indexs[i]] > min) {
                    nextMin = Math.max(nextMin, mat[i][indexs[i]]);
                    find = false;
                }
            }
            min = nextMin;
        }
        return find?min:-1;
    }
}