package solution.arrayType;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 描述：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 思路：
 * 1、遍历数组，使用target-nums[i]计算每一个满足条件的值
 * 2、将元素按照nums[i],i的结构放入Map,判断Map中是否包含条件1的结果
 * 3、返回元素下标
 * @author sleeper
 * @version 1.0
 * 2021/3/20
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ;i<nums.length;i++){
            int key =  target - nums[i];
            if(map.containsKey(key)){
                return new  int[]{map.get(key), i};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }

}
