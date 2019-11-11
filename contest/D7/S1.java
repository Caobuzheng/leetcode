class Solution1165 {
    public int calculateTime(String keyboard, String word) {
        int[] keyMap = new int[26];
        for(int i = 0; i< keyboard.length(); i++) {
            keyMap[keyboard.charAt(i) - 'a'] = i;
        }
        int last = 0;
        int ans = 0;
        for(char c: word.toCharArray()) {
            int next = keyboard[c-'a'];
            ans+= Math.abs(next - last);
            last = next;
        }
        return ans;
    }
}