package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangran
 * 2018/10/4
 */

public class SingleNumber136 {

	public int singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int num1 : nums) {
			if (map.containsKey(num1)) {
				map.put(num1, 1);
			} else {
				map.put(num1, 0);
			}
		}

		for (Integer num : map.keySet()) {
			if (map.get(num) != 1) {
				return num;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
	}
}
