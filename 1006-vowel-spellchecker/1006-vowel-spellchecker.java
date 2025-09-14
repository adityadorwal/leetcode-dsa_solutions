
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Store exact matches
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

        // 2. Maps for case-insensitive and vowel-masked matches
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelMaskedMap = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();

            // Store first occurrence for case-insensitive map
            caseInsensitiveMap.putIfAbsent(lower, word);

            // Store first occurrence for vowel-masked map
            String masked = maskVowels(lower);
            vowelMaskedMap.putIfAbsent(masked, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactWords.contains(q)) {
                // Rule 1: Exact match (case-sensitive)
                result[i] = q;
            } else {
                String lowerQ = q.toLowerCase();

                if (caseInsensitiveMap.containsKey(lowerQ)) {
                    // Rule 2: Case-insensitive match
                    result[i] = caseInsensitiveMap.get(lowerQ);
                } else {
                    String maskedQ = maskVowels(lowerQ);

                    if (vowelMaskedMap.containsKey(maskedQ)) {
                        // Rule 3: Vowel-error match
                        result[i] = vowelMaskedMap.get(maskedQ);
                    } else {
                        // No match
                        result[i] = "";
                    }
                }
            }
        }
        return result;
    }

    // Helper to replace vowels with '*'
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}