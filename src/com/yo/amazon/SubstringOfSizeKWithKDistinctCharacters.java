package com.yo.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringOfSizeKWithKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(generateList("awaglknagawunagwkwagl", 4));
    }

    private static List<String> generateList(String s, int k) {
        Set<String> res = new HashSet<>();
        Set<Character> window = new HashSet<>();
        if (s.length() < k) return new ArrayList<>(res);
        for (int l=0, r=0; r < s.length(); r++) {
            while(window.contains(s.charAt(r))) {
                window.remove(s.charAt(l++));
            }
            window.add(s.charAt(r));
            if (window.size() == k) {
                res.add(s.substring(l, r+1));
                window.remove(s.charAt(l++));
            }
        }

        return new ArrayList<>(res);
    }
}
