import java.util.*;
// Solution1166
class FileSystem {
    Map<String, Integer> fs;
    public FileSystem() {
        fs = new HashMap<>();
        fs.put("", 0); // 作为root
    }
    
    public boolean createPath(String path, int value) {
       if(map.containsKey(path)) return false;
       int lastIndex = path.lastIndexOf("\/");
       if(!map.containsKey(path.substring(0, lastIndext))) return false;
       map.put(path, value);
       return true;
    }
    
    public int get(String path) {
        return map.get(path);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */