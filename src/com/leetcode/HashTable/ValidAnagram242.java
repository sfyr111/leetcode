package com.leetcode.HashTable;

/**
 * Created by yangran
 * 2018/10/5
 */
// String 双引号, char 单引号
public class ValidAnagram242 {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}

		for (int e : arr) {
			if (e != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

		boolean b = isAnagram("anagram", "nagaram");
		System.out.println(b);
	}
}
