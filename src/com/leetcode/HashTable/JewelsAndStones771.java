package com.leetcode.HashTable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangran
 * 2018/11/13
 */

public class JewelsAndStones771 {

	public int numJewelsInStones(String J, String S) {
		int res = 0;
		Set set = new HashSet<>();
		for (char j : J.toCharArray())
			set.add(j);
		for (char s : S.toCharArray())
			if (set.contains(s)) res++;
		return res;
	}
}
