package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangran
 * 2018/10/25
 */

public class LongestSubstringWithoutRepeatingCharacters3 {

	public class Solution1 {
		public int lengthOfLongestSubstring(String s) {
			int len = s.length();
			int ans = 0;
			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j <= len; j++) {
					if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
				}
			}
			return ans;
		}

		private boolean allUnique(String s, int start, int end) {
			Set<Character> set = new HashSet<>();
			for (int i = start; i < end; i++) {
				Character ch = s.charAt(i);
				if (set.contains(ch)) return false;
				set.add(ch);
			}
			return true;
		}
	}

	public class Solution2 {
		public int lengthOfLongestSubstring(String s) {
			int len = s.length();
			Set<Character> set = new HashSet<>();
			int ans = 0, i = 0, j = 0;
			while (i < len && j < len) {
				if (!set.contains(s.charAt(j))) {
					set.add(s.charAt(j++));
					ans = Math.max(ans, j - i);
				} else {
					set.remove(s.charAt(i++));
				}
			}
			return ans;
		}
	}

	public class Solution3 {
		public int lengthOfLongestSubstring(String s) {
			int len = s.length();
			int ans = 0;
			Map<Character, Integer> map = new HashMap<>(); // 当前 character 的 index
			for (int i = 0, j = 0; j < len; j++) {
				if (map.containsKey(s.charAt(j))) {
					i = Math.max(map.get(s.charAt(j)), i);
				}
				ans = Math.max(ans, j - i + 1);
				map.put(s.charAt(j), j + 1);
			}
			return ans;
		}
	}

	public class Solution4 {
		public int lengthOfLongestSubstring(String s) {
			int len = s.length();
			int ans = 0;
			int[] index = new int[128];
			for (int i = 0, j = 0; j < len; j++) {
				i = Math.max(index[s.charAt(j)], i);
				ans = Math.max(ans, j - i + 1);
				index[s.charAt(j)] = j + 1;
			}
			return ans;
		}
	}

	public static void main(String[] args) {
	}
}
