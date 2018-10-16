package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangran
 * 2018/10/15
 */

public class TopKFrequentElements347 {

	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null)
				bucket[frequency] = new ArrayList<>();
			bucket[frequency].add(key);
		}

		List<Integer> ret = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >=0 && ret.size() < k; pos--) {
			if (bucket[pos] != null)
				ret.addAll(bucket[pos]);
		}
		return ret;
	}
}
