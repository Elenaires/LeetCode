class Solution {
    public boolean isPalindrome(int x) {
        String digit = Integer.toString(x);
        int i = 0;
        int j = digit.length() - 1;
        
        boolean palindrome = true;
        while(i <= j && palindrome)
        {
            if(digit.charAt(i) != digit.charAt(j))
            {
                palindrome = false;
            }
            i++;
            j--;
        }
        
        return palindrome;
    }
}
