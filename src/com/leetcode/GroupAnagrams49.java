package com.leetcode;

import java.util.*;

/**
 * Created by yangran
 * 2018/10/17
 */

// ["eat", "tea", "tan", "ate", "nat", "bat"]
public class GroupAnagrams49 {
	public ArrayList<List<String>> groupAnagrams1(String[] strArr) {
		if (strArr.length == 0) return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strArr) {
			char[] ca = s.toCharArray(); // 弄成字符数组 ['e', 'a', 't']
			Arrays.sort(ca); // 排序 ['a', 'e', 't']
			String key = String.valueOf(ca); // 获得一个唯一 key: "aet"
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(s); // key: "aet", value: "eat"
		}
//		System.out.println(map); // {aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]}
//		System.out.println(new ArrayList<>(map.values())); // [[eat, tea, ate], [bat], [tan, nat]]]
		return new ArrayList<>(map.values()); //
	}

	public ArrayList<List<String>> groupAnagrams2(String[] strArr) {
		if (strArr.length == 0) return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		int[] count = new int[26];
		for (String s : strArr){
			Arrays.fill(count, 0);
			for (char c : s.toCharArray()) {
				count[c - 'a']++;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		ArrayList<List<String>> r1 = new GroupAnagrams49().groupAnagrams1(strs);
		ArrayList<List<String>> r2 = new GroupAnagrams49().groupAnagrams2(strs);
		System.out.println(r1);
		System.out.println(r2);
	}
}
