package com.yo.amazon;

public class ItemsInContainer {
    public static void main(String[] args) {
        //int[] res = itemsInContainer(new int[]{1,1}, new int[]{5,6}, "|**|*|*");
        int[] res = itemsInContainer(new int[]{1,1}, new int[]{5,7}, "***|****");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] itemsInContainer(int[] start, int[] end, String s) {
        int[] res = new int[start.length];
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int[] sum = new int[s.length()];

        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*')
                count++;
            sum[i] = count;
        }

        count = -1;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '|')
                count = i;
            left[i] = count;
        }


        count = -1;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '|')
                count = i;
            right[i] = count;
        }

        for(int i=0; i<start.length; i++) {
            int a = start[i]-1;
            int b = end[i]-1;

            if(left[b] != -1 && right[a] != -1) {
                res[i] = sum[left[b]] - sum[right[a]];
            }
        }
        return res;
    }
}
