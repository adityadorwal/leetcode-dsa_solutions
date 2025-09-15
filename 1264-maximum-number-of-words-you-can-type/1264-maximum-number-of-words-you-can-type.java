class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Step 1: Build a fast boolean lookup table
        boolean[] broken = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken[brokenLetters.charAt(i) - 'a'] = true;
        }

        int count = 0;
        boolean wordHasBroken = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                if (!wordHasBroken) count++;
                wordHasBroken = false; // reset for next word
            } else if (broken[ch - 'a']) {
                wordHasBroken = true; // mark this word as untypable
            }
        }

        // check last word (no trailing space)
        if (!wordHasBroken) count++;

        return count;
    }
}
