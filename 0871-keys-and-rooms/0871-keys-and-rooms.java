class Solution {
    public void bfs(List<List<Integer>> rooms,boolean []visited,int i)
    {
        visited[i]=true;
        for(int k:rooms.get(i))
        {
            if(!visited[k]) bfs(rooms,visited,k);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        bfs(rooms,visited,0);
        for(boolean i:visited)if(!i)return false;
        return true;
    }
}