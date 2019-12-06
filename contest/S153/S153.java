import java.time.LocalDate;

/**
 * S153
 */
public class S153 {

    public static void main(String[] args) {
        S153 s = new S153();
    }

    //1 <= arr.length <= 10^5
    // -10^4 <= arr[i] <= 10^4
    // sum 可能也需要用long的哦。
    public int maximumSum(int[] arr) {
        // 这个跟那个很像。基本上也都是靠套路了的。
        int maxOne = Integer.MIN_VALUE;
        for(int i: arr) maxOne = Math.max(maxOne, i);
        if(maxOne <=0) return maxOne;
        // 就是sun + minValue的情况。
        // 不太好写的呀。不过大概就是那个意思的。
    }


    static final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static final int[] monthDays = {
        31,28,31,30,31,30,31,31,30,31,30,31
    };
    public String dayOfTheWeek(int day, int month, int year) {
        int countDay = 0;
        for(int i = 1970; i< year;i++) {
            if(i%4 == 0 && i!= 2100) countDay+=366;
            else countDay+=365;
        }
        for(int i = 1; i< month;i++) {
            if(i==2 && year%4==0 && year != 2100)  countDay+=29;
            else countDay+=monthDays[i-1];
        }
         countDay+=day;
         countDay+=3;
         return days[countDay%7];
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination) return distanceBetweenBusStops(distance, destination, start);
        int sum = 0;
        for(int i: distance) sum+=i;
        int tmp = 0;

        for(int i = start; i<destination;i++) {
            tmp += distance[i];
        }
        return Math.min(tmp, sum-tmp);
    }

    
}