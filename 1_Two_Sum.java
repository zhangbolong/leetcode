/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.

@Example 
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
@基本思路
    循环，把数放到map里，用target减去num[i]来查找另一个数有没有在map里，如果有的话两个数就找出来了，如果没有的话就把下一对
    放进map来继续循环
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 
        //先建立一个 Map
        HashMap<Integer, Integer> map = new HashMap<>();
        //一个循环
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = map.get(target - nums[i]);
            }
            
            map.put(nums[i], i);
        }
    }
}