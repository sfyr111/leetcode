package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangran
 * 2018/10/4
 */

public class TwoSum1 {
	public static int[] twoSum(int[] nums, int target) {
		// 1. Map<value, index>
		Map<Integer, Integer> numMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], i);
		}
		System.out.println(numMap);
		for (int j = 0; j < nums.length; j++) {
			// 2. 找出出现过的 value
			int c = target - nums[j];
			// 3. 不能是自己当前的序号 numMap.get(c) != j
			if (numMap.containsKey(c) && numMap.get(c) != j) {
				return new int[]{ j, numMap.get(c) };
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3,2,4};
		int target = 6;
		int[] result = twoSum(arr, target);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
}
