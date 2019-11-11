import java.util.LinkedList;
import java.util.Map;

class Solution1088 {
    static int[] map = {0,1,5,-1,-4, 2, 9,-1,8,6};
    public int confusingNumberII(int N) {
        int ans=0;
        int[] num={1,6,8,9};
        for(int i=0;i<num.length;i++){
            ans+=dfs(N,num[i]);
        }
        return ans;
    }
    public int dfs(int N,int curr){
        int[] num={0,1,6,8,9};
        if(curr>N){
            return 0;
        }
         int ans=0;
        if(bingo(curr)){
            ans++;
        }
        if(curr==N){
            return ans;
        }
        if(curr*10>N){
            return ans;
        }
       
        for(int i=0;i<num.length;i++){
           int t=dfs(N,curr*10+num[i]);
            ans+=t;
        }
        return ans;
    }

    boolean bingo(int n) {
        int res = 0;
        int tmp = n;
        while(tmp>0) {
            int i = tmp%10;
            if(map[i] != -1){
                res=res*10+i;
            }else {
                return false;
            }
            tmp/=10;
        }
        return res!=n;
    }
}