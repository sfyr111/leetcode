package com.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangran
 * 2018/11/20
 */

public class FindAllNumbersDisappearedInAnArray448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0)
				nums[val] = -nums[val];
		}
		for (int n : nums) {
			System.out.print(n + ", ");
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				ret.add(i + 1);
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> r = new FindAllNumbersDisappearedInAnArray448().findDisappearedNumbers(nums);
		for (int n : r) {
			System.out.print(n);
		}
	}
}
