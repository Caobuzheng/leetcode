public class SortArrayByParityII {
    // https://leetcode-cn.com/contest/weekly-contest-106/problems/sort-array-by-parity-ii/
    public static void main(String[] args) {
        int[] A = {3,4};
        for(int i: sortArrayByParityII(A)){
            System.out.println();
            System.out.print(i);
            System.out.println();
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        int ou = 0;
        int ji = 1;
        while(ou < A.length/2 * 2 && ou<A.length ) {
            if(A[ou] % 2 != 0) {
                while(ji<A.length && A[ji] % 2 != 0) {
                    ji+=2;
                }
                int c = A[ou];
                A[ou] = A[ji];
                A[ji] = c;
            }
            ou+=2;
        }
        return A;    
    }
}