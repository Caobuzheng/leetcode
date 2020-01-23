import java.util.*;
public class Do16 {
    public static void main(String[] args) {
        Do16 d = new Do16();
    }


    public int[] pathsWithMaxScore(List<String> board) {
        // board 是个正方形。
    }

    public int deepestLeavesSum(TreeNode root) {
        Queue queue = new LinkedList<>();
        if(root == null) return 0;
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for(int i = 0; i<size;i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return sum;
    }

    public int findBestValue(int[] arr, int target) {
        int l = 1;
        int r = target;
        while(l<=r) {
            int mid = (l+r) / 2;
            int sum = getSum(arr, mid);
            if(sum == target) return mid;
            else if(sum>target) {
                int sum1 = getSum(arr,mid-1);
                if(sum1 <= target) {
                    if(sum-target >= target - sum1) return mid-1;
                    else return mid;
                }
                r = mid-1;
            }
            else if(sum<target) {
                int sum2 = getSum(arr,mid+1);
                if(sum2 >= target) {
                    if(sum2 - target >= target - sum2) return mid;
                    else return mid+1;
                }
                l = mid+1;
            }
        }
        return -1;
    }

    public int getSum(int[] arr, int mid) {
        int sum = 0;
        for(int i: arr) {
            if(i>mid) {
                sum+=mid;
            }else {
                sum+=i;
            }
        }
        return sum;
    }

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = -1;
        for(int i = len-1;i>=0;i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp, max);
        }
        return arr;
    }
}


class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; } }