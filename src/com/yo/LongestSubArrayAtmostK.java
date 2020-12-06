package com.yo;

import java.util.HashMap;

public class LongestSubArrayAtmostK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, -8, -9, 0};
        System.out.println(atMostSum(arr, arr.length, 4));
    }

    public static int atMostSum(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }
}
