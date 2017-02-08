import java.util.ArrayList;
import java.util.List;

public class Leet_500_Keyboard_Row {
	/**
	 * 本题是为了找到输入的字符串数组中满足题目要求的字符串：可以在美式键盘用一行字母拼成的字符串
	 * 可以将键盘中的三行字母构建成三行n列的二维字符数组，
	 * 使用二层循环迭代输入值words和键盘数组，
	 * 对每一个字符串都要检查其是否可以由当前行组成。
	 * @param words
	 * @return
	 */
    public String[] findWords(String[] words) {
        char[][] table = new char[3][];
        table[0] = "qwertyuiop".toCharArray();
        table[1] = "asdfghjkl".toCharArray();
        table[2] = "zxcvbnm".toCharArray();
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < words.length; ++i){
        	for(int j = 0; j < 3; ++j){
        		int flag = check(words[i], table[j]);
        		if(flag == 1){
        			result.add(words[i]);
        		}else if(flag == -1){
        			break;
        		}
        	}
        }
        return (String[])result.toArray(new String[result.size()]);
    }
    
    /**
     * 这个方法是针对某一个word，检测它是否可以用键盘上的一行字母拼出来
     * @param word
     * @param tableX
     * @return 0代表不可以，1代表可以， -1代表出错
     */
    int check(String word, char[] tableX){
    	word = word.toLowerCase();
    	int flag = 0;
    	boolean exist = false;
    	boolean not_exist = false;
    	for(int i = 0; i < word.length(); ++i){
    		char temp = word.charAt(i);
    		if(contain(temp, tableX)){
    			exist = true;
    		}else{
    			not_exist = true;
    		}
    		if(exist && not_exist){
    			flag = -1;
    			break;
    		}
    	}
    	if(!exist){
    		flag = 0;
    	}
    	if(exist && !not_exist){
    		flag = 1;
    	}
    	return flag;
    }
    
    /**
     * 这个方法是检查一个word中的某个字符是否存在于键盘的某一列中
     * @param charInWord
     * @param tableX
     * @return
     */
    boolean contain(char charInWord, char[] tableX){
    	boolean isExist = false;
    	for(int i = 0; i < tableX.length; ++i){
    		if(charInWord == tableX[i]){
    			isExist = true;
    			break;
    		}
    	}
    	return isExist;
    }
}
