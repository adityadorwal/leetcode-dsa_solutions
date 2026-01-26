class Solution {
    public String predictPartyVictory(String senate) {
        int pw_r = 0, pw_d = 0;
        int len = 0;
        StringBuilder str = new StringBuilder();

        while (len != senate.length()) {
            len = senate.length();
            for (int i = 0; i < len; i++) {

                char ch = senate.charAt(i);
                if (ch == 'R') {
                    if (pw_d > 0)
                        pw_d--;
                    else {
                        pw_r++;
                        str.append(ch);
                    }
                } else {
                    if (pw_r > 0)
                        pw_r--;
                    else {
                        pw_d++;
                        str.append(ch);
                    }
                }
            }
            senate = str.toString();
            str.setLength(0);
        }
        return (senate.charAt(0)=='R')? "Radiant" : "Dire";
    }
}