package com;

public class Leet_6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
    	if(s==null || s.length()==0 || numRows<=0) {
            return "";
        }
        if(numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        /*
         * a   e
         * b d f
         * c   g
         * 从a到d为一个zig，size: 一个zig的大小
         */
        int size = 2*numRows-2;
        for(int i=0; i<numRows; i++) {
            // 外层循环i表示第几行（从0开始）
            // 内层序号j表示第几个zig（从0开始）
            for(int j=i; j<s.length(); j+=size) {
                res.append(s.charAt(j));
                // zig的第一行和最后一行中间的行
                // 每一个zig有两个元素在同一行，如：b和d在同一行
                // 同一行中的两个元素之间的距离是：size-2*i(size一个zig的大小，i当前是第几行，从0开始）
                // 同一个zig中的第一个元素在s中的位置是j，第二个元素在s中的位置是：j+size-2*i
                if(i>0 && i<numRows-1) {
                    int mid = j+size-2*i;
                    if(mid<s.length()) {
                        res.append(s.charAt(mid));
                    }
                }
            }
        }
        return res.toString();
    }
}
