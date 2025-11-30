class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int k=0;
        for(int i=1;i<=n;i++)
        {
            if(target[k] == i)
            {
                result.add("Push");
                k++;
            }
            else
            {
                result.add("Push");
                result.add("Pop");
            }
            if(k==target.length)break;
        }
        return result;
    }
}