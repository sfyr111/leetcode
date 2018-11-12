package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangran
 * 2018/10/16
 */

public class FourSumII454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int c : C) {
			for (int d : D) {
				int sum = c + d;
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		System.out.println(map);

		int res = 0;

		for (int a : A) {
			for (int b : B) {
				res += map.getOrDefault(-1 * (a + b), 0);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = new int[]{1, 2};
		int[] B = new int[]{-2, -1};
		int[] C = new int[]{-1, 2};
		int[] D = new int[]{0, 2};

		int r = new FourSumII454().fourSumCount(A, B, C, D);
		System.out.println(r);
	}
}
