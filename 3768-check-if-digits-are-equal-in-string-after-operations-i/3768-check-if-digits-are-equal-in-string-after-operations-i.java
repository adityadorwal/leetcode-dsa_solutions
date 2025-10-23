class Solution {
    public boolean hasSameDigits(String s) {

        int len = s.length();
        int arr[] = new int[len];
        for(int i=0;i<len;i++)arr[i]=s.charAt(i)-'0';
        while(len>2)
        {
            for(int i=1;i<len;i++)
            {
                arr[i-1] = (arr[i-1]+arr[i])%10;
            }
            len--;
        }
        return arr[0] == arr[1];
    }
}