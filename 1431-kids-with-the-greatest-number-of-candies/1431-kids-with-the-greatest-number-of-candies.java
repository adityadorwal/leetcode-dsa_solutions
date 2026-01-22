class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max =0;
        for(int i=0;i<candies.length;i++)
        {
            int num = candies[i];
            if(num > max)max = num;
            candies[i] = num+extraCandies;
        }
        for(int i:candies)result.add(i>=max);
        return result;
    }
}