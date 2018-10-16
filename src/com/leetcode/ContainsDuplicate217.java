package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangran
 * 2018/10/8
 */

public class ContainsDuplicate217 {

	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return true;
			}
			map.put(nums[i], 1);
		}
		return false;
	}

	public boolean containsDuplicate1(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n))
				return true;
			set.add(n);
		}
		return false;
	}
}
