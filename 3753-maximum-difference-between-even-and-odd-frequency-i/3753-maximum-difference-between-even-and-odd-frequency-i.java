/******************************BY using HashMAp ************************************ */

// class Solution {
//     public int maxDifference(String s) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         int odd_max=0,even_max=Integer.MAX_VALUE;
//         for(int i=0;i<s.length();i++)
//         {
//             char ch = s.charAt(i);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
//         for(char i:map.keySet())
//         {
//             int num = map.get(i);
//             if(num%2==0)even_max = Math.min(even_max,num);
//             else odd_max = Math.max(odd_max,num);
//         }
//         return odd_max-even_max;
//     }
// }

/*******************************By using array************************************* */
class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        int maxi = 0, mini = s.length();
        for (char ch : s.toCharArray())arr[ch - 'a']++;
        
        for (int i = 0; i < 26; i++)
        {
            if (arr[i] % 2 != 0)maxi = Math.max(maxi, arr[i]);
    
            if (arr[i] % 2 == 0 && arr[i] > 0)mini = Math.min(mini, arr[i]);
        }
        return maxi - mini;
    }
}