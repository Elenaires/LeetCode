class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.isEmpty())
        {
            return 0;
        }
        
        int start = 0;
        int maxLength = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i-start);
        }
        
        return maxLength + 1;
    }
}
