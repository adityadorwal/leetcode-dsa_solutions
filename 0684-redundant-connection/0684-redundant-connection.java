class Solution {
    public int find(int x,int[] parent)
    {
        if(parent[x] != x) parent[x] = find(parent[x],parent); 
        return parent[x];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int []parent = new int[edges.length+1];
        for(int i=0;i<edges.length;i++)parent[i]=i;

        for(int []i:edges)
        {
            int u=find(i[0],parent), v=find(i[1],parent);
            if(u==v)return i;
            parent[u] = v;
        }
        return new int[]{};
    }
}