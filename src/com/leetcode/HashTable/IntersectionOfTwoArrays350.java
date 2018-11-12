package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangran
 * 2018/10/11
 */

public class IntersectionOfTwoArrays350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int num1 : nums1) {
			if (map.containsKey(num1))
				map.put(num1, map.get(num1) + 1);
			else
				map.put(num1, 1);
		}
		System.out.println(map);

		for (int num2 : nums2) {
			if (map.containsKey(num2) && map.get(num2) > 0) {
				list.add(num2);
				map.put(num2, map.get(num2) - 1);
			}
		}
		System.out.println(map);
		System.out.println(list);

		int[] ret = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{4,9,5};
		int[] nums2 = new int[]{9,4,9,8,4};

		int[] result = new IntersectionOfTwoArrays350().intersect(nums1, nums2);
		for (int item : result) {
			System.out.print(item);
		}
		System.out.println();
	}
}
