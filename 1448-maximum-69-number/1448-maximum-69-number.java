/*********************************Pure Mathematical Solution *********************************** */
class Solution {
    public int maximum69Number (int num) {
        int x =num,c=0,d=-1;
        while(x>0)
        {
            if(x%10 == 6)d=c;
            x=x/10;
            c++;
        }
        if(d==-1)return num;
        d=(int)Math.pow(10,d);
        num = (num/d + 3)*d + (num%d);
        return num;
    }
}

/**********************************String Methods****************************************************** */

// class Solution {
//     public int maximum69Number (int num) {
//         String s = String.valueOf(num);
//         return Integer.parseInt(s.replaceFirst("6", "9"));
//     }
// }
