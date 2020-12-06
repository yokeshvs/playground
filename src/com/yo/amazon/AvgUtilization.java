package com.yo.amazon;

public class AvgUtilization {
    public static void main(String[] args) {
        System.out.println(finalInstances(5, new int[]{30,5,4,8,19,89}));
    }

    public static int finalInstances(int instances, int[] averageUtil) {
        int i=0;
        while(i<averageUtil.length) {
            if(averageUtil[i] < 25 && instances > 1) {
                instances = instances / 2 + ((instances % 2 == 0) ? 0 : 1);
                i = i + 10;
            } else if(averageUtil[i] > 60 && instances * 2 <= 2 * (Math.pow(10,8))) {
                instances = 2 * instances;
                i = i + 10;
            } else {
                i++;
            }
        }
        return instances;
    }
}
