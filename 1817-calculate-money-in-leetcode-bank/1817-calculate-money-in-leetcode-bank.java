class Solution {
    public int totalMoney(int n) {
        int sum=0;
        int num=28;
        int k=1;
        while(n>0)
        {
            if(n>7)
            {
                sum += num;
                num += 7;
                k++;
                n -= 7;
            }
            else
            {
                sum+=k;
                k++;
                n--;
            }
        }
        return sum;
    }
}