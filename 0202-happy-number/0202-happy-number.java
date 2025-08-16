class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> num = new HashSet<>();
        num.add(n);
        while(n!=1)
        {
            int sum=0;
            while(n>0)
            {
                int rem = n%10;
                sum+=rem*rem; 
                n=n/10;
            }
            n=sum;
            if(num.contains(n))return false;
            num.add(n);
        }
        return true;
    }
}