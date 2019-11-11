class Solution1151{
    public static void main(String[] args) {
        Solution1151 s = new Solution1151();
        int[] data = {1,0,1,0,1,0,0,1,1,0,1};//3
        int[] data2 = {1,0,1,0,1}; //1
        int[] data3 = {0,0,0,1,0}; //0
        // 1 <= data.length <= 10^5 
        // 搜索跟递归，我这两个最会的，似乎是不行的。
        // 其实就是1跟某个0去换位置的。
        System.out.println(s.minSwaps(data));
        System.out.println(s.minSwaps(data2));
        System.out.println(s.minSwaps(data3));
        // 计算个xx距离的吧？似乎能可行
    }
    public int minSwaps(int[] data) {
        int count = 0;
        for(int i: data) if(i==1) count++;
        if(count <= 1) return 0;
        int window = 0;
        for(int i = 0; i< count-1; i++) if(data[i] == 1) window++;
        int min = count;
        for(int i = count-1,j=0; i<data.length;i++,j++) {
            if(data[i] == 1) window++;
            min = Math.min(min, count-window);
            if(data[j] == 1) window--;
        }
        return min;
    }
}