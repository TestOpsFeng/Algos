package top.testops.basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 暴力法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int j = 0; j < len; j++) {
            for (int k = 0; k < len; k++) {
                if (nums[j] + nums[k] == target) {
                    if (j != k) {
                        return new int[]{j, k};
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 相差
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int offset = target - nums[i];
            for (int j = 0; j < len; j++) {
                if (offset == nums[j]) {
                    if (i != j) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 相差优化
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int offset = target - nums[i];
            for (int j = i + 1; j < len; j++) {
                if (offset == nums[j]) {
                    if (i != j) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{i, map.get(result)};
            }
        }
        return null;
    }

    /**
     * 哈希表优化
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum5(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
//             && map.get(result) != i
            if (map.containsKey(result)) {
                return new int[]{ map.get(result),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
