package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/21
 */

public class ShortestUnsortedContinuousSubarray581 {
	public int findUnsortedSubarray(int[] nums) {
		int len = nums.length, max = nums[0], min = nums[len - 1], start = -1, end = -2; // 考虑 [1, 2, 3, 4] 返回 end - start + 1 == 0

		for (int i = 1; i < len; i++) {
			// 理论当前最大值 max 为 nums[i]
			// 理论当前最小值 min 为 nums[len - 1 - i]
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[len - 1 - i]);
			if (max > nums[i]) end = i; // 违反理论 max 记录 end
			if (min < nums[len - i - 1]) start = len - 1 - i; // 违反理论 min 记录 start
		}
		return end - start + 1; // 返回有多少个数
	}

	public static void main(String[] args) {
//		int[] nums = {2, 6, 4, 8, 10, 9, 15}; // [6, 4, 8, 10, 9] 找到6的序号 start， 找到最后一个 j+1 <= j 的位置，end = j+1
		int[] nums = {1, 2, 3, 4}; // [6, 4, 8, 10, 9] 找到6的序号 start， 找到最后一个 j+1 <= j 的位置，end = j+1
		int len = new ShortestUnsortedContinuousSubarray581().findUnsortedSubarray(nums);
		System.out.println(len);
	}
}
