
class Solution1087 {
    public static void main(String[] args) {
        System.out.println("asd");
    }



    public String[] expand(String S) {
        // 讲道理是处理一下才更好的操作的来。
        List<String> list = new LinkedList<>();
    }

    void help(String remain, int index, char[] chars, List<String> list) {
        StringBuilder sb = new StringBuilder();
        int i = index;
        while(i<chars.length && chars[i] != '[') {
            sb.append(chars[i]);
        }

    }

}