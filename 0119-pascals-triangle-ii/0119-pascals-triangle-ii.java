class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        while(rowIndex>=0)
        {
            rowIndex--;
            List<Integer> temp = new ArrayList<>();
            int s=0;
            for(int i:list)
            {
                temp.add(s+i);
                s=i;
            }
            temp.add(1);
            list = temp;
        }
        return list;
    }
}