package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangran
 * 2018/11/10
 */

public class MinimumWindowSubstring76 {
	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		// Dictionary which keeps a count of all the unique characters in t.
		// 保存t中所有唯一字符计数的字典 A=1 B=1 C=1
		Map<Character, Integer> dictT = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			int count = dictT.getOrDefault(t.charAt(i), 0);
			dictT.put(t.charAt(i), count + 1);
		}

		// Number of unique characters in t, which need to be present in the desired window.
		// t中唯一字符的数量，需要出现在所需的窗口中。
		int required = dictT.size();

		// Left and Right pointer
		int l = 0, r = 0;

		// formed is used to keep track of how many unique characters in t 					//形成用于跟踪t中有多少个唯一字符
		// are present in the current window in its desired frequency. 							//以所需频率出现在当前窗口中。
		// e.g. if t is "AABC" then the window must have two A's, one B and one C. //例如 如果t是“AABC”那么窗口必须有两个A，一个B和一个C.
		// Thus formed would be = 3 when all these conditions are met.						 //当满足所有这些条件时，这样形成的将是= 3。
		int formed = 0;

		// Dictionary which keeps a count of all the unique characters in the current window.
		// 保存当前窗口中所有唯一字符计数的字典。
		Map<Character, Integer> windowCounts = new HashMap<>();

		// ans list of the form (window length, left, right) // ans表单列表（窗口长度，左，右）
		int[] ans = {-1, 0, 0};

		while (r < s.length()) {
			// Add one character from the right to the window // 从右侧向窗口添加一个字符
			char c = s.charAt(r);
			int count = windowCounts.getOrDefault(c, 0);
			windowCounts.put(c, count + 1);

			// If the frequency of the current character added equals to the // 如果添加的当前字符的频率等于
			// desired count in t then increment the formed count by 1. // t中的所需计数然后将形成的计数增加1。
			if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
				formed++;
			}

			// Try and contract the window till the point where it ceases to be 'desirable'. //尝试收缩窗口，直到它不再是“理想的”。
			while (l <= r && formed == required) {
				c = s.charAt(l);
				// Save the smallest window until now. 保存最小的窗口直到现在。
				if (ans[0] == -1 || r - l + 1 < ans[0]) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}

				// The character at the position pointed by the //由指向的位置处的角色
				// `Left` pointer is no longer a part of the window. //“左”指针不再是窗口的一部分。
				windowCounts.put(c, windowCounts.get(c) - 1);
				if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
					formed--;
				}

				// Move the left pointer ahead, this would help to look for a new window. //向前移动左指针，这有助于寻找新窗口。
				l++;
			}

			// Keep expanding the window once we are done contracting. //完成合同后继续扩展窗口。
			r++;
		}

		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String r = new MinimumWindowSubstring76().minWindow(s, t);
		System.out.println(r);
	}
}
