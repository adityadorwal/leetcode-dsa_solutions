class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        int L = beginWord.length();
        Map<String, List<String>> patternMap = new HashMap<>();

        // Preprocessing: build pattern map
        for (String word : dict) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            if (word.equals(endWord)) return level;

            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> neighbors = patternMap.getOrDefault(pattern, new ArrayList<>());
                for (String nei : neighbors) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(new Pair<>(nei, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
