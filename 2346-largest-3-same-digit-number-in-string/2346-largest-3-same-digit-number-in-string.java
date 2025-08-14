class Solution {
    public String largestGoodInteger(String num) {
        char best = 0;
        for (int i = 0; i < num.length() - 2; i++)
        {
            char ch = num.charAt(i);
            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2) && ch > best)best = ch;
        }
        return best == 0 ? "" : "" + best + best + best;
    }
}
