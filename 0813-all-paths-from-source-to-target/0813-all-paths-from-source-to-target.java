class Solution {
    public void dfs(int[][] graph,List<List<Integer>> ans,List<Integer> temp,int i)
    {
        temp.add(i);
        if(i==graph.length-1)
        {
            ArrayList<Integer> copy=new ArrayList<>();
            copy.addAll(temp);
            ans.add(copy);
        }
        else
        {
            int arr[] = graph[i];
            for(int k=0;k<arr.length;k++)
            {
                dfs(graph,ans,temp,arr[k]);
            }
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<graph[0].length;i++)
        {
            List<Integer>temp = new ArrayList<>();
            temp.add(0);
            dfs(graph,ans,temp,graph[0][i]);
        }
        return ans;
    }
}