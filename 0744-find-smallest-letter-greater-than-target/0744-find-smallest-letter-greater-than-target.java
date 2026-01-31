class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char min=' ';
        for(char ch:letters)
        {
            if(ch>target && (min ==' ' || min > ch)) min = ch;
        }
        return (min == ' ')?letters[0]:min;
    }
}