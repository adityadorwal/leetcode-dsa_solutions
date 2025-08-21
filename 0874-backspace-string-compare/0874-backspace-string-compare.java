//***********************************By using Stack*************************** */
// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         Stack<Character> stk1 = new Stack<>();
//         Stack<Character> stk2 = new Stack<>();
//         for(int i=0 ; i<s.length() ; i++)
//         {
//             char ch = s.charAt(i);
//             if(ch != '#' )stk1.push(ch);
//             else if(!stk1.isEmpty())stk1.pop();
//         }
//         for(int i=0 ; i<t.length() ; i++)
//         {
//             char ch = t.charAt(i);
            
//             if(ch != '#' )stk2.push(ch);
//             else if(!stk2.isEmpty())stk2.pop();
//         }
//         return (stk1.equals(stk2));
//     }
// }

/*******************************************Using two pointer approch ********************************* */

class Solution {
    public int get_next_valid_char_index(String str, int end)
    {
        int backspace_count = 0;
        while (end >= 0)
        {
            if (str.charAt(end) == '#')backspace_count++;
            else if (backspace_count > 0)backspace_count--;
            else break;
            end--;
        }
        return end;
    }    

    public boolean backspaceCompare(String s, String t) {
        int ps = s.length() - 1;
        int pt = t.length() - 1;

        while (ps >= 0 || pt >= 0)
        {
            ps = get_next_valid_char_index(s, ps);
            pt = get_next_valid_char_index(t, pt);

            if (ps < 0 && pt < 0) return true;
            if (ps < 0 || pt < 0) return false;
            else if (s.charAt(ps) != t.charAt(pt)) return false;
            ps--;
            pt--;
        }
        return true;        
    }
}