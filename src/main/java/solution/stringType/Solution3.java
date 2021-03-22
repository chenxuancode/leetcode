package solution.stringType;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 思路(滑动窗口)：
 * 1、遍历处理字符串，初始化窗口的左边界left为0，窗口的右边界即为当前遍历的元素下标，使用Map存储遍历过的元素
 * 2、每一次遍历中，判断当前元素在Map中是否包含当前元素，如果包含则将重复元素中第一个出现的元素排除在窗口外，即left=map.get(chars[right]) + 1
 * 3、记录窗口在滑动过程中的最长长度
 * @author sleeper
 * @version 1.0
 * 2021/3/15
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // 滑动窗口（不重复子串）的左边界
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap();
        for (int right = 0; right < chars.length; right++) {
            if (map.containsKey(chars[right])) {
                // 每次移动的步数=重复元素第一次出现的位置+1，即要将重复元素中第一个出现的排除在窗口外，  使用max()是解决abba的问题
                left = Math.max(left, map.get(chars[right]) + 1);
            }
            // 每个元素存放在存放在Map中，用以辅助左边界的移动
            map.put(chars[right], right);
            // i - left + 1 表示当前窗口的长度，maxLen表示窗口移动过程中最长的窗口长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
