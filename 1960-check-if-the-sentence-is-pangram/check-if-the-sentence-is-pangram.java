class Solution {
    public boolean checkIfPangram(String sentence) {
         boolean[] itsPresent = new boolean[26];
         for (char ch : sentence.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                itsPresent[ch - 'a'] = true;
            }
        }
        for (boolean letterPresent : itsPresent) {
            if (!letterPresent) {
                return false;
            }
        }
        return true;
    }
}