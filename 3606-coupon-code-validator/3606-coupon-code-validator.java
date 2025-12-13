class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> e = new ArrayList<>();
        List<String> g = new ArrayList<>();
        List<String> p = new ArrayList<>();
        List<String> r = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            int k = 0;
            if (isActive[i] && code[i].length() > 0) {
                String str = code[i];
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '_') {
                        continue;
                    }
                    k = 1;
                }
                if (k == 0) {
                    char ch = businessLine[i].charAt(0);
                    if (ch == 'e')
                        e.add(str);
                    else if (ch == 'g')
                        g.add(str);
                    else if (ch == 'p')
                        p.add(str);
                    else if (ch == 'r')
                        r.add(str);
                }
            }
        }
        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);
        e.addAll(g);
        e.addAll(p);
        e.addAll(r);
        return e;
    }
}