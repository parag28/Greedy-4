
class Solution {
    public int shortestWay(String source, String target) {
        int i = 0; // Pointer for source
        int j = 0; // Pointer for target
        int count = 0; // Number of subsequences
        
        while (j < target.length()) {
            int start = j; // Mark the start of the current subsequence
            
            while (i < source.length() && j < target.length()) {
                if (source.charAt(i) == target.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            
            if (j == start) {
                // If no progress is made, it's impossible to form target
                return -1;
            }
            
            count++;
            i = 0; // Reset source pointer for the next subsequence
        }
        
        return count;
    }
}

