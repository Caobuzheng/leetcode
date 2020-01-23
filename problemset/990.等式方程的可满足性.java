/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    static int[] fa;
    public static boolean equationsPossible(String[] equations) {
        fa = new int[26];
        for(int i = 0;i<26; i++){
            fa[i] = i;
        }
        List<int[]> eqList = new LinkedList<>();
        List<int[]> notEqList = new LinkedList<>();
        for (String str: equations) {
            int[] xyeq = help(str);
            int eq = xyeq[2];
            if(eq == 1){
                eqList.add(xyeq);
            }else {
                notEqList.add(xyeq);
            }
        }
        Collections.sort(eqList, (o1, o2) ->o1[0]-o2[0]);

        for(int[] xyeq: eqList) {
            int x = xyeq[0];
            int y = xyeq[1];
            int fax = getFa(x);
            int fay = getFa(y);
            if(fax != fay){
                if(fax<fay) {
                    fa[y] = fax;
                }else {
                    fa[x] = fay;
                }
            }
        }
        for(int[] xyeq: notEqList) {
            int x = xyeq[0];
            int y = xyeq[1];
            int fax = getFa(x);
            int fay = getFa(y);
            if(fax == fay){
                return false;
            }
        }
        return true;
    }
    public static int getFa(int i) {
        if(fa[i] != i) {
            return getFa(fa[i]);
        }
        return i;
    }
    public static int[] help(String str) {
        char[] chars = str.toCharArray();
        // 判断如果是连通的，但这个是个false，就返回false的呗。难度不那么大。
        int eq = 1;
        if(chars[1] == '!'){
            eq = 0;
        }
        if(chars[0] < chars[3]) {
            return new int[]{chars[0] -'a', chars[3] -'a', eq};
        }else {
            return new int[]{chars[3] -'a', chars[0] -'a', eq};
        }
    }
}
// @lc code=end

