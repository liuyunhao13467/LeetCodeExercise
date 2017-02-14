import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	//我们使用数组来存储nums中的元素以及其出现的次数，在这里，我们使用数组下标来表示出现的次数（至于为什么，后面会有所解释），因此一共n+1项（第0项不算）
    	//这个数组中的每一个元素都是一个list，为什么是这样而非普通的int数组呢（就像下面的对比实验数组一样），
    	//这是由bucket数组的功能以及它个部分所代表的意义决定的：bucket使用下标表示元素出现次数，bucket元素值表示nums中的对应元素
    	//但是这种对应关系不是一对一的，例如，在nums中，有三个数都出现了1次，那么普通的int数组（比如buCket这样的数组）就不能正确的表达bucket应有的含义
    	//因此我们使用这中多维的数据结构，使用二维数组也可以
    	List<Integer>[] bucket = new List[nums.length + 1];
    	int[] buCket = new int[nums.length + 1];
    	
    	//使用一个hashmap来存储nums中元素到该元素出现次数的映射，即key：nums中的元素，value：该元素出现的次数
    	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    	//统计nums中每个元素出现的次数，将结果存储在frequencymap中
    	for (int n : nums) {
    		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    	}
    	//（对比实验）
    	for(int i = buCket.length - 1; i >= 0; --i){
    		buCket[i] = 0;
    	}
    	//将统计好的各元素以及其出现的次数放入bucket数组中
    	//
    	for (int key : frequencyMap.keySet()) {
    		int frequency = frequencyMap.get(key);
    		if (bucket[frequency] == null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		bucket[frequency].add(key);
    		buCket[frequency] = key;
    		
    		//test
    		System.out.println("Key: " + key + "; frequency: " + frequency);
    	}
    	//结果集，注意，在实例化之后要clear一下，因为初始的时候里面可能有默认值，他不是空的
    	List<Integer> res = new ArrayList<>();
    	res.clear();
    	//逆序遍历bucket，这里解释一下为何使用数组下标作为元素出现次数
    	//因为是要求top k，因此正常情况下我们应该对计算的结果（每个元素出现的次数）进行排序，但是由于我们采取了这样一种机制：
    	//使用数组下标值表示出现次数（因为出现次数是有限的，它一定小于n）
    	//所以我们不再需要排序了，只需要逆序（从大往小）遍历k次就可以找到top k了。
    	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
    		if (bucket[pos] != null) {
    			res.addAll(bucket[pos]);
    		}
    	}
    	
    	//对比测试
//    	for(int i = buCket.length - 1; i >= 0 && res.size() < k; --i){
//    		if(buCket[i] != 0){
//    			res.add(buCket[i]);
//    		}
//    	}
    	
    	for(int i = buCket.length - 1; i >= 0; --i){
    		System.out.println("frequency: "+i+";key: "+buCket[i]);
    	}
    	
    	//对比测试
//    	for(int i = buCket.length - 1, j = 0; i >= 0 && j < k; --i){
//    		if(buCket[i] != 0){
//    			res.add(buCket[i]);
//    			++j;
//    		}
//    	}
    	return res;
    }
}
