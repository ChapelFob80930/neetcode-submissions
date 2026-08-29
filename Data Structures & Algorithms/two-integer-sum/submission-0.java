class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){

            int numRequired = target - nums[i];

            if(map.containsKey(numRequired)){
                return new int[] {map.get(numRequired), i};
            }

            map.put(nums[i], i);

        }

        return new int[] {};
    }
}
