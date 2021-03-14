package com.example.myleetcode.util;

public class ArrayUtils {
    /**
     * 字符串转二维数组
     * @param arr
     * @return
     */
    public static int[][] stringToTwoArray(String arr) {
        arr = arr.replace("\n", "");
        arr = arr.trim().substring(1, arr.length() - 1);
        int index = 0;
        int left = -1;
        int xLenth = 0;
        int x = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '[') {
                xLenth++;
            }
        }
        int[][] result = null;
        while (index < arr.length()) {
            char c = arr.charAt(index);
            if (c == '[') {
                left = index;
            }
            if (c == ']') {
                String[] brr = arr.substring(left + 1, index).split(",");
                if (result == null) {
                    result = new int[xLenth][brr.length];
                }
                int[] row = new int[brr.length];
                for (int i = 0; i < brr.length; i++) {
                    row[i] = Integer.parseInt(brr[i].trim());
                }
                result[x++] = row;
                left = -1;
            }
            index++;
        }
        return result;
    }
}
