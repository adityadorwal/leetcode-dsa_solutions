class Solution {
    public int countPrimes(int n) {
        boolean arr[] = new boolean[n];
        int l = (int)Math.floor(Math.sqrt(n));
        if(n<2)return 0;
        arr[0]=true;
        arr[1]=true;
        
        for(int i=2; i<=l;i++)
        {
            if(arr[i] == false)
            for(int j = i*i ; j<n ; j+=i)arr[j]=true;
        }
        l=0;
        for(boolean z : arr)if(!z)l++;
        
        return l;
    }
}