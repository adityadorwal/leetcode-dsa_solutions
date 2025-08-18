class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int num1 = -1,num2 = -1;
        int max_len=1 , left=0;
        for(int right =0 ; right<fruits.length;right++)
        {
            int new_num = fruits[right];
            if(map.size()<2)
            {
                if(num1==-1)num1 = new_num;
                else num2 = new_num;
            }
            else
            {
                if(!map.containsKey(new_num))
                {
                    if(fruits[right-1]==num1)
                    {
                        left = map.get(num2)+1;
                        map.remove(num2);
                        num2 = new_num;
                    }
                    else
                    {
                        left = map.get(num1)+1;
                        map.remove(num1);
                        num1 = new_num;
                    }
                }
            }
            map.put(new_num,right);
            System.out.println(left+" "+right);
            max_len = Math.max(right-left+1,max_len);
        }
        return max_len;
    }
}