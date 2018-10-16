package com.leetcode;

/**
 * Created by yangran
 * 2018/10/8
 */

public class FirstUniqueCharacterInAString387 {
	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		for (int j = 0; j < s.length(); j++) {
			if (arr[s.charAt(j) - 'a'] == 1) {
				return j;
			}
		}
		return -1;
	}
}
