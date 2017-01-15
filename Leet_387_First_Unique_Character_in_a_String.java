public class Solution {
    public int firstUniqChar(String s) {
        int[] table = new int[26];//建立映射表，表示在字符串S中各个字符出现了多少次
		for(int i = 0; i < table.length; ++i){//每个元素都初始化为0
			table[i] = 0;
		}
		for(int i = 0; i < s.length(); ++i){//计算s中每个字符出现的个数
			char current = s.charAt(i);
			++table[current - 'a'];
		}
		for(int i = 0; i < s.length(); ++i){//遍历s，查看每一个字符出现的次数
			if(table[s.charAt(i) - 'a'] == 1){//返回第一个只出现一次的字符的位置
				return i;
			}
		}
		return -1;
    }
}
