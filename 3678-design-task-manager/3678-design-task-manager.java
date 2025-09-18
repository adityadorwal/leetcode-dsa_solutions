class TaskManager {
    HashMap<Integer,int[]> tsk_pri;
    PriorityQueue<int []> que;
    Comparator<int[]> cmp = (a, b) -> {
    int diff = b[1] - a[1];
    if (diff != 0) return diff; 
    return b[0]-a[0];
};

    public TaskManager(List<List<Integer>> tasks) {
        tsk_pri = new HashMap<>();
        que = new PriorityQueue<>(cmp);

        for(List<Integer> data:tasks)
        {
            int taskid=data.get(1) , priority=data.get(2);
            que.offer(new int[]{taskid,priority});
            tsk_pri.put(taskid,new int[]{data.get(0),priority});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        que.offer(new int[]{taskId,priority});
        tsk_pri.put(taskId,new int []{userId,priority});
    }
    
    public void edit(int taskId, int newPriority) {
        tsk_pri.put(taskId,new int[]{tsk_pri.get(taskId)[0],newPriority});
        que.offer(new int[]{taskId,newPriority});
    }
    
    public void rmv(int taskId) {
        tsk_pri.remove(taskId);
    }
    
    public int execTop() {
        if(que.isEmpty())return -1;
        
        int arr[] = que.poll();
        int tskid = arr[0];

        if(!tsk_pri.containsKey(tskid)) return execTop();
        
        int ans[]=tsk_pri.get(tskid);
        if(arr[1] != ans[1])
        {
            que.offer(new int[]{tskid,ans[1]});
            return execTop();
        }
        tsk_pri.remove(tskid);
        return ans[0];
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */