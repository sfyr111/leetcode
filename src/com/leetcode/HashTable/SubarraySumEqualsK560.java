package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangran
 * 2018/11/13
 */

public class SubarraySumEqualsK560 {

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		// sum: count
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); // 0 出现一次
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) // x + y = sum, sum - k 为之前出现的次数
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
