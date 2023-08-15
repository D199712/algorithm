package cn.itcast.algorithm.interview;


import java.util.HashMap;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class NC61 {

    /**暴力枚举
     * 双重for循环遍历数组+if判断两数和是否等于target
     * 时间复杂度: O(N2)
     * 空间复杂度: O(1)
     */
    public int[] twoNum1(int[] nums,int target){
        int len = nums.length;
        for (int i = 0;i < len;i++){
            for (int j = i+1; j < len; j++){
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0};
    }

    /**哈希表
     *创建一个哈希表，对于nums[i],判断target - nums[i]是否在哈希表中存在相同key值
     * 如果存在返回map.get(target - nums[i]),i，如果不存在，把nums[i],i插入map
     */
    public int[] twoNum2(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }else {
                map.put(nums[i],i);
            }

        }
        throw new IllegalArgumentException("No");
    }
}
