class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26]; // letter frequency
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] num = new int[10];

        // unique identifiers
        num[0] = count['z' - 'a']; // zero
        num[2] = count['w' - 'a']; // two
        num[4] = count['u' - 'a']; // four
        num[6] = count['x' - 'a']; // six
        num[8] = count['g' - 'a']; // eight

        // dependent ones
        num[1] = count['o' - 'a'] - num[0] - num[2] - num[4];
        num[3] = count['r' - 'a'] - num[0] - num[4];
        num[5] = count['f' - 'a'] - num[4];
        num[7] = count['v' - 'a'] - num[5];
        num[9] = count['i' - 'a'] - num[5] - num[6] - num[8];

        // build result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < num[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
