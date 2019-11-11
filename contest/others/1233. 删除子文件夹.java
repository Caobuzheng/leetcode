import java.util.LinkedList;

class Solution1233 {
    public static void main(String[] args) {
        String[] folder1 = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        // ["/a","/c/d","/c/f"]
        System.out.println(String.join(",", removeSubfolders(folder1)));
        String[] folder2 = {"/a","/a/b/c","/a/b/d"};
        System.out.println(String.join(",", removeSubfolders(folder2)));
        String[] folder3 = {"/a/b/c","/a/b/d","/a/b/ca"};
        System.out.println(String.join(",", removeSubfolders(folder3)));
    }
    public static List<String> removeSubfolders(String[] folder) {
        List<String> res = new LinkedList<>();
        // 会有/b/c的情况么？
        return res;
    }
}