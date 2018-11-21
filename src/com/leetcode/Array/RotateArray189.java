package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/20
 */

public class RotateArray189 {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start; // 序号
			int prev = nums[start]; // 元素
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next]; // 下一个位置的元素
				nums[next] = prev;
				prev = temp;
				current = next; // 更新序号
				count++;
			} while (start != current);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		int k = 2;
		new RotateArray189().rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
}
