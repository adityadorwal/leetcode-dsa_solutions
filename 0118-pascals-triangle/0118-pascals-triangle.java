class Solution {
    public void form(List<List<Integer>> list,int numRows)
    {
        if(numRows == 0)return;

        int l = list.size();
        List<Integer> arr = new ArrayList<>();
        List<Integer> temp = list.get(l-1);
        arr.add(1);
        for(int i=1;i<l;i++)
        {
            arr.add(temp.get(i-1)+temp.get(i));
        }
        arr.add(1);
        list.add(arr);
        form(list,numRows-1);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        list.add(arr);
        form(list,numRows-1);
        return list;
    }
}