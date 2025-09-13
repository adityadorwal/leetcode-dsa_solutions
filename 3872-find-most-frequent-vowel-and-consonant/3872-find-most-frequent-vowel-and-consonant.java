class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0, maxConso = 0;
        for (char c : s.toCharArray())
        {
            int i = c - 'a';
            freq[i]++;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                maxVowel = Math.max(maxVowel, freq[i]);
            else
                maxConso = Math.max(maxConso, freq[i]);
        }
        return maxVowel + maxConso;
    }
}


// class Solution {
//     public int maxFreqSum(String s) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         int max_vowel=0,max_consonant=0;
//         for(int i=0;i<s.length();i++)
//         {
//             char ch = s.charAt(i);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//             if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') max_vowel = Math.max(max_vowel,map.get(ch));
//             else max_consonant = Math.max(max_consonant,map.get(ch));
//         }
//         return max_consonant+max_vowel;
//     }
// }