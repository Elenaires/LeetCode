class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        if(s.length() == 1) {
            return 1;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int length = 0;
        int start = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
        
            if(!map.containsKey(c)) {
                map.put(c, i);
                length++;
            }
            else {
                maxLength = Math.max(maxLength, length);
                int end = map.get(c);
                while(start <= end) {
                    map.remove(s.charAt(start));
                    length--;
                    start++;
                }
                map.put(c, i);
                length++;
            }
        }
        return Math.max(maxLength, length);
    }
}
