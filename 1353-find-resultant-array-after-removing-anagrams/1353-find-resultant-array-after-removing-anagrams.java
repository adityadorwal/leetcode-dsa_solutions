import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSorted = ""; // to store previous word sorted

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // sort characters
            String sortedWord = new String(chars);

            if (!sortedWord.equals(prevSorted)) {
                result.add(word); // keep word if not an anagram of previous
                prevSorted = sortedWord; // update previous
            }
        }

        return result;
    }
}
