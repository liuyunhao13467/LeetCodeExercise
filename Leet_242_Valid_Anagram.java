public class Leet_242_Valid_Anagram {
	/**
	 * 这道题是让判断两个变形数组的内容是否相同，有两种做法：
	 * 一个是将两数组排序后依次对比数组中相应元素是否相同；
	 * 第二种做法是建立哈希表（一个长为26的int数组，每个元素表示string中各个字母出现的次数），
	 * 最后通过比对两string的哈希表中各个元素的值是否相等来判定。
	 * 我们从采用第二种方法
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		//如果两个string的长度不同，直接pass
		if(s.length() != t.length())
			return false;
		//构造hash table
		int[] table = new int[26];
		//统计s中各个字母出现的个数
		for(int i = 0; i < s.length(); ++i){
			++table[s.charAt(i) - 'a'];
		}
		//统计t中各个字母出现的次数，这里直接在原hash table上做减法就好，
		//最后看hash table的值是否等于零
		for(int i = 0; i < t.length(); ++i){
			--table[t.charAt(i) - 'a'];
		}
		for(int i = 0; i < 26; ++i){
			if(table[i] != 0)
				return false;
		}
		return true;
    }
}
