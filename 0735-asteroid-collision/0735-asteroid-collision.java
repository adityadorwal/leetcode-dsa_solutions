class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque <Integer> stk = new ArrayDeque<Integer>();
        int i;
        for(i=0;i<asteroids.length;i++)
        {
            int aster=asteroids[i];
            if(aster>0)
            stk.push(aster);
            else
            {
                aster*=-1;
                while(!stk.isEmpty() && stk.peek()<aster && stk.peek()>0)stk.pop();
                if(!stk.isEmpty() && stk.peek()==aster)stk.pop();
                else if(!stk.isEmpty() && stk.peek()>aster)continue;
                else stk.push(aster*-1);
            }
        }
        int[] intArray = new int[stk.size()]; 
        for(i=stk.size()-1;i>=0;i--)intArray[i]=stk.pop();
        return( intArray);
    }
}