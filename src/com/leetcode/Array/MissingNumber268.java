package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/16
 */

public class MissingNumber268 {
	public int missingNumber(int[] nums) {
		// 期望的和
		int expectedSum = nums.length * (nums.length + 1) / 2;
		// 实际的和
		int actualSum = 0;
		for (int num : nums)
			actualSum += num;
		return expectedSum - actualSum;
	}
}
