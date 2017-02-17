package com;

public class Leet_11_Container_With_Most_Water {
	/**
	 * 穷举法，正确但是超时
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	int maxWater = 0;
        //穷举法
    	for(int i = 0; i < height.length; ++i){
    		for(int j = i + 1; j < height.length; ++j){
    			int tmp = (j - i) * Math.min(height[i], height[j]);
    			maxWater = Math.max(maxWater, tmp);
    		}
    	}
    	return maxWater;
    }
    
    /**
     * 容积即面积，它受长和高的影响，当长度减小时候，高必须增长才有可能提升面积，所以我们从长度最长时开始递减，然后寻找更高的线来更新候补
     * 最大容积C = min( a[i] , a[j] ) * ( j- i )
     * 这个问题需要用到两个性质：
     * 1.在 j 的右端没有一条线会比它高。
     * 证明：假设存在k( j<k && a[k] > a[j])，那么由a[k]>a[j]，所以min( a[i],a[j], a[k]) =min(a[i],a[j])，
     * 所以由i, k构成的容器的容积C' = min(a[i],a[j] ) * (k-i) > C，与C是最值矛盾，所以得证j的后边不会有比它还高的线
     * 2.在i的左边也不会有比它高的线
     * 因此：如果我们目前得到的候选：设为 x, y两条线（x< y)，
     * 那么能够得到比它更大容积的新的两条边必然在[x,y]区间内并且 a[x]' > =a[x] , a[y]'>= a[y];
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
    	int i = 0, j = height.length - 1;
    	int maxC = 0, curC = 0;
    	while(i < j){
    		curC = Math.min(height[i], height[j]) * (j - i);
    		maxC = maxC<curC?curC:maxC;
    		if(height[i] > height[j]){//右边的线相对来说较低，而它的右侧又没有比他更高的线，为了使容积更大，我们要将j左移
    			j--;
    		}else{
    			i++;
    		}
    	}
        return maxC;
    }
}
