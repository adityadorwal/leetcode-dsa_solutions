class TimeMap {
    HashMap<Integer,String> val;
    HashMap<String,ArrayList<Integer>> map; 
    public TimeMap() {
        val = new HashMap<>();
        map= new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        map.put(key,new ArrayList<Integer>());

        map.get(key).add(timestamp);
        val.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key))
        {
            int left = 0;
            ArrayList<Integer> arr = map.get(key);
            int right = arr.size()-1;

            while(left<=right)
            {
                int mid = left + (right - left)/2;
                if(arr.get(mid)==timestamp)return(val.get(timestamp));
                else if(arr.get(mid)<timestamp)
                left = mid+1;
                else 
                right = mid-1;
            }
            if(right>=0)
            return(val.get(arr.get(right)));
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */