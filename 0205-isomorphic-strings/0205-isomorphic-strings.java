// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         HashMap<Character,Character> map = new HashMap<>();
//         HashSet<Character> set = new HashSet<>();
//         for(int i=0;i<s.length();i++)
//         {
//             char ch1 = s.charAt(i) , ch2 = t.charAt(i);
//             if(map.containsKey(ch1))
//             {
//                 if(map.get(ch1)!=ch2)return false;
//             }
//             else
//             {
//                 if(set.contains(ch2))return false;
//                 map.put(ch1,ch2);
//             }
//             set.add(ch2);
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];  // stores mapping s[i] → t[i]
        int[] map2 = new int[256];  // stores mapping t[i] → s[i]

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // if not mapped yet, create new mapping
            if (map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = c2;
                map2[c2] = c1;
            }
            // if already mapped, check consistency
            else if (map1[c1] != c2) {
                return false;
            }
        }
        return true;
    }
}
