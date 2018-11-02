package com.leetcode;

import java.util.*;

/**
 * Created by yangran
 * 2018/11/2
 */

public class FindAllAnaramsInAString438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new LinkedList<>();
		if (p.length() > s.length()) return result;
		Map<Character, Integer> map = new HashMap<>(); // map for p
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int couter = map.size();

		int begin = 0, end = 0;

		System.out.print(map);
		System.out.println(couter);

		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) - 1);
				if (map.get(c1) == 0) couter--; // couter == 0, map 的 key 全部找到
			}
			end++;

			// map 的 key 全部找到, 进行匹配
			while (couter == 0) {
				char c2 = s.charAt(begin);
				if (map.containsKey(c2 )) {
					map.put(c2 , map.get(c2 ) + 1);
					if (map.get(c2 ) > 0) couter++;
				}
				if (end - begin == p.length())
					result.add(begin);
				begin++;
			}
		}
		return result;
	}

	public List<Integer> findAnagrams1(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (p.length() > s.length()) return list;
		int[] hash = new int[256];

		for (char c : p.toCharArray())
			hash[c]++;

		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			// 向右走，s 里 char 在 hash 里存在则 >= 1 , hash 里匹配完了就是 0
			if (hash[s.charAt(right++)]-- >= 1) count--;
			// count == 0, 匹配到结果，将 left 添加
			if (count == 0) list.add(left);
			//
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
		}
		return list;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";

//		List<Integer> list = new FindAllAnaramsInAString438().findAnagrams(s, p);
		List<Integer> list = new FindAllAnaramsInAString438().findAnagrams1(s, p);
		System.out.println(list);
	}
}
