import java.util.HashMap;
import java.util.Map;

public class ThreeSumMulti {
    static Integer MOD = 1000_000_000+7;
    public static int threeSumMulti(int[] A, int target) {
        Long res = 0L;
        for(int i=0;i<A.length;i++) {
            for(int j=i+1;j<A.length;j++) {
                for(int k=j+1;k<A.length;k++) {
                    if(A[i] + A[j] + A[k] == target) {
                        res++;
                    }
                }
            }
        }
        res = res%MOD;
        return res.intValue();
    }
    public static void main(String[] args) {
        int[] A = {1,1,2,2,3,3,4,4,5,5};
        System.out.println(threeSumMulti(A, 8)); // 20
        int[] B = {1,1,2,2,2,2};
        System.out.println(threeSumMulti(B, 5)); // 12
    }
}