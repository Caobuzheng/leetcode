import java.util.Arrays;

/**
 * D13_1
 */
class D13_1 {

    public static void main(String[] args) {
        for(int i = 0; i<=8;i++) {
            System.out.println(encode(i));
        }
    }

    public static String encode(int num) {
        if(num == 0) return "";
        int count = 1;
        int index = 1;
        int c = 2;
        while(count+c<num) {
            index++;
            count+=c;
            c*=2;
        }
        count = num-count;
        char[] chars = new char[index];
        Arrays.fill(chars, '0');
        index = 0;
        while(count>0) {
            chars[index++] = count%2;
            count/=2;
        }
        int r = 0;
        int l = chars.length-1;
        while(r<l) {
            char cc = chars[r];
            chars[r++] = chars[l];
            chars[l--] = c;
        }
        return new String(chars);
    }
}