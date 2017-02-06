public class Leet_409_Longest_Palindrome {
	
	public int longestPalindrome(String s) {
        int result = 0;
        //哈希表，在字符串中，每个字母的出现的次数
        int[] upperTable = new int[26];
        int[] lowerTable = new int[26];
        //遍历string，找出串中每个字母出现了几次
        for(int i = 0; i < s.length(); ++i){
        	//此处要区分大写字母和小写字母
        	if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
        		++upperTable[s.charAt(i) - 'A'];
        	}else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
        		++lowerTable[s.charAt(i) - 'a'];
        	}
        }
        //统计哈希表，计算结果
        boolean flag = false;//要考虑到回文序列的最大长度：如果有奇数次的字母存在的话，result应该是加一的，因为可以在回文序列的最中间加入一个单个元素，这可以使序列长度最大化同时保证顺序逆序读结果相同。
        for(int i = 0; i < 26; ++i){
        	if(upperTable[i] % 2 == 0){
        		result = result + upperTable[i];
        	}else if(upperTable[i] % 2 != 0){
        		result = result + upperTable[i] - 1;
        		flag = true;
        	}
        	if(lowerTable[i] % 2 == 0){
        		result = result + lowerTable[i];
        	}else if(lowerTable[i] % 2 != 0){
        		result = result + lowerTable[i] - 1;
        		flag = true;
        	}
        }
        //如果string中存在奇数次的字符，那么result要加一以保证长度最大化
        if(flag == true){
        	result++;
        }
        return result;
    }
}
