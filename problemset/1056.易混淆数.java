class Solution1056 {
    public static void main(String[] args) {
        System.out.println(confusingNumber(0));
        System.out.println(confusingNumber(6));
        System.out.println(confusingNumber(11));
        System.out.println(confusingNumber(89));
        System.out.println(confusingNumber(25));
    }

    public static boolean confusingNumber(int N) {
       String n = "" + N;
       char[] charn = n.toCharArray();
       char[] chars = new char[charn.length];
       for(int i = 0; i<charn.length;i++) {
            if(charn[i] == '0') chars[chars.length-i-1] = '0';
            else if(charn[i] == '1') chars[chars.length-i-1] = '1';
            else if(charn[i] == '6') chars[chars.length-i-1] = '9';
            else if(charn[i] == '8') chars[chars.length-i-1] = '8';
            else if(charn[i] == '9') chars[chars.length-i-1] = '6';
            else return false;
       }
       for(int i = 0; i<charn.length;i++) {
          if(charn[i] != chars[i]) return true;
       }
       return false;
    }
}