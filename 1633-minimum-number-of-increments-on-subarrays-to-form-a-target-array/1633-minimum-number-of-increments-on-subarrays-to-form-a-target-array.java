class Solution {
    public int minNumberOperations(int[] target) {
        int pre=0 , result=0;
        for(int i:target)
        {
            if(i>pre) result += i-pre;
            pre = i;
        }
        return result;
    }
}