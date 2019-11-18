// brute force O(n^3) - Time Limit Exceeded

class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0) {
            return "";
        }
        
        String longestPalindrome = "";
        int maxLength = 0;
        
        for(int i = 0; i < s.length(); i++) { // O(n^2)
            for(int j = i+1; j < s.length()+1; j++) {
                String substring = s.substring(i,j);
                if(isPalindrome(substring)) { // O(n)
                    if(maxLength < substring.length()) {
                        maxLength = substring.length();
                        longestPalindrome = substring;
                    }
                }
            }
        }      
        return longestPalindrome;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        
        while(j >= i) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
