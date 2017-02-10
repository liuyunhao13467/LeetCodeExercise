import java.util.HashMap;
import java.util.Map;

public class Leet_447_Number_of_Boomerangs {
	/**
	 * 题目输入的三个点是以二维数组的形式存在的，
	 * 第一维代表点，第二维代表该点的x，y坐标
	 * 因此，我们只需遍历第一维即可。
	 * 实际上是排列组合问题，求当前点与除自己之外的其他点的距离，
	 * 然后查找是否有相同的距离，相同的距离出现了几次，
	 * 根据相同距离出现的次数，求排列组合就可以得到结果
	 * @param points
	 * @return
	 */
    public int numberOfBoomerangs(int[][] points) {
        int reslut = 0;
        //构造一个map，key表示两点之间的距离值，value表示该距离值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //第一层循环就是访问每个点（第一维）
        for(int i = 0; i < points.length; ++i){
        	//第二层循环要访问除第i个点之外的其他点（还是第一维），在这个过程中计算点i和其他点（j）的距离，并统计相同距离出现的次数
        	for(int j = 0; j < points.length; ++j){
        		//计算点i到自己的距离无意义，跳过
        		if(j == i){
        			continue;
        		}
        		//虽然欧氏距离是坐标之差的平方相加之后再开方，但是这里只需要比较距离是否相同，并不用求出距离的具体值
        		int distance = ((points[i][0] - points[j][0]) * (points[i][0] - points[j][0])) + 
        				((points[i][1] - points[j][1]) * (points[i][1] - points[j][1]));
        		if(map.containsKey(distance)){
        			map.put(distance, map.get(distance)+1);
        		}else{
        			map.put(distance, 1);
        		}
        	}
        	//根据所得的i点到其他点的距离以及每个距离值出现的次数，计算可以构造多少boomerangs
        	for(int val : map.values()){
        		reslut += val*(val-1);//排列组合
        	}
        	map.clear();
        }
        return reslut;
    }
}
