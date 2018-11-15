package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/15
 */

public class MajorityElement169 {

	public int majorityElement(int[] nums) {

		int major = nums[0], count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i])
				count++;
			else count--;
		}

		return major;
	}

	public static void main(String[] args) {
//		int[] nums = {3, 2, 3};
		int[] nums = {1, 2, 3};
//		int[] nums = {1, 1, 3, 3, 5, 1, 1};
		int r = new MajorityElement169().majorityElement(nums);
		System.out.println(r);
	}
}
