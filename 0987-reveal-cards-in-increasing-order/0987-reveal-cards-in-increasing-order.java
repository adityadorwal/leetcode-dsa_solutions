class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int k=0,len=deck.length;
        int result[] = new int[len];
        Deque <Integer> que = new ArrayDeque();
        for (int i=0 ; i<len ; i++)que.offer(i);
        
        while(k+1<len)
        {
            result[que.poll()] = deck[k++];
            que.offer(que.poll());
        }
        result[que.poll()] = deck[k++];
        return result;
    }
}