class Solution {
    public int compress(char[] chars) {
        int start_point = 0;
        char prev = ' ';
        int ind = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (prev == chars[i])
                count++;
            else {
                if (count > 1) {
                    String temp = Integer.toString(count);
                    for (int j = 0; j < temp.length(); j++) {
                        chars[ind++] = temp.charAt(j);
                    }
                }
                prev = chars[i];
                chars[ind++] = prev;
                count = 1;
            }
        }
        if (count > 1) {
            String temp = Integer.toString(count);
            for (int j = 0; j < temp.length(); j++) {
                chars[ind++] = temp.charAt(j);
            }
        }
        return ind;
    }
}