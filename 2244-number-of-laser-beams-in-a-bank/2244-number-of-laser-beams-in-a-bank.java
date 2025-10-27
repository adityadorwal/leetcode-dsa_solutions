class Solution {
    public int numberOfBeams(String[] bank) {
        int i=0;
        int len = bank[0].length();
        int past=0,sum=0;
        char arr[]= new char[len];
        while(i<bank.length)
        {
            arr = bank[i].toCharArray();
            int c=0;
            for(int j=0;j<len;j++)
            {
                if(arr[j]=='1')c++;
            }
            if(c>0)
            {
                sum += past*c;
                past = c;
            }
            i++;
        }
        return sum;
    }
}