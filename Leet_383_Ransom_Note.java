public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //思路就是统计两个字符串里每个字符的个数，然后比较：
		    //遍历两字符串中26个英文字母的个数，对于同一个字母的个数来时，magazine的比ransomNote的大即可
		
		    //为两个字符串建立26个字母的数量映射数组，并初始化
        int[] ransomNoteAlphabet = new int[26];
        for(int i = 0; i < ransomNoteAlphabet.length; ++i)
          ransomNoteAlphabet[i] = 0;
        int[] magazineAlphabet = new int[26];
        for(int j = 0; j < magazineAlphabet.length; ++j)
        	magazineAlphabet[j] = 0;
        //开始统计字符串中每个字母的个数
        for(int i = 0; i < ransomNote.length(); ++i){
        	ransomNoteAlphabet[ransomNote.charAt(i) - 'a']++;
        }
        for(int j = 0; j < magazine.length(); ++j){
        	magazineAlphabet[magazine.charAt(j) - 'a']++;
        }
        //开始比较各个字母的个数
        boolean result = true;
        boolean[] resultArray = new boolean[26];
        for(int i = 0; i < 26; ++i){
        	if(magazineAlphabet[i] >= ransomNoteAlphabet[i]){
        		resultArray[i] = true;
        	}else{
        		resultArray[i] = false;
        	}
        }
        //看是否存在magazine中的某个字母数量比ransomNote中对应字母数量小的
        for(int i = 0; i < 26; ++i){
        	if(resultArray[i] == false)
        		result = false;
        }
        return result;
    }
}
