class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum=mass;
        int last_aster=asteroids[asteroids.length-1];
        for(int i:asteroids)
        {
            if(sum<i)return false;
            if(sum>=last_aster)return true;
            sum+=i;
        }
        return true;
    }
}