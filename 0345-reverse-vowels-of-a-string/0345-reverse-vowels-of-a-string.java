class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        int p = 0, q = len - 1;
        StringBuilder str = new StringBuilder(s);
        while (p < q) {
            char chp=' ' , chq=' ';
            while (p<len) {
                chp = str.charAt(p);
                if (chp == 'a' || chp == 'e' || chp == 'i' || chp == 'o' || chp == 'u' ||
                        chp == 'A' || chp == 'E' || chp  == 'I' || chp == 'O' || chp == 'U')
                    break;
                p++;
            }
            while (q>=0) {
                chq = str.charAt(q);
                if (chq == 'a' || chq == 'e' || chq == 'i' || chq == 'o' || chq == 'u' ||
                        chq == 'A' || chq == 'E' || chq == 'I' || chq == 'O' || chq == 'U')
                    break;
                q--;
            }
            if(p<q)
            {
                str.setCharAt(p,chq);
                str.setCharAt(q,chp);
                p++;
                q--;
            }
        }
        return str.toString();
    }
}