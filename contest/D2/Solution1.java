class Solution1085 {
    public static void main(String[] args) {
        int[] A = {34,23,1,24,75,33,54,8};
        System.out.println(sumOfDigits(A));
    }
    public static int sumOfDigits(int[] A) {
        int min = A[0];
        for(int i: A) {
            min = Math.min(min, i);
        }
        int res = 0;
        while(min > 0) {
            res += min %10;
            min/=10;
        }
        return res&1;
    }
}