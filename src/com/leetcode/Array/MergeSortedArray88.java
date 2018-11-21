package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/20
 */

public class MergeSortedArray88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j])
				nums1[index--] = nums1[i--];
			else // if (nums1[i] <= nums2[j])
				nums1[index--] = nums2[j--];
		}
		while (j >= 0) // i < 0, nums1 先遍历完, j < 0 nums2 先遍历完不需要合并 nums1,因为已经在 nums1 上了
			nums1[index--] = nums2[j--];
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;
		new MergeSortedArray88().merge(nums1, m, nums2, n);
		for (int k : nums1) {
			System.out.print(k);
		}
	}
}
