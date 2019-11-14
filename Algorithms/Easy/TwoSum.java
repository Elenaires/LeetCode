class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int diff = 0;
        for(int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return new int[2];
    }
}
