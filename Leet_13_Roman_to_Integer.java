import java.util.HashMap;
import java.util.Map;

public class Leet_13_Roman_to_Integer {
	/**
	 * Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
	 * (1)相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
	 * (2)小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
	 * (3)小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
	 * 这里的实现先不考虑ixc的情况
	 * @param s
	 * @return
	 */
    public int romanToInt(String s) {
    	int res=0;
        Map<Character,Integer> save=new HashMap<Character,Integer>();
        save.put('I',1);
        save.put('V',5);
        save.put('X',10);
        save.put('L',50);
        save.put('C',100);
        save.put('D',500);
        save.put('M',1000);
        int prev=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            int current=save.get(s.charAt(i));
            if(current>=prev)
            {
                res+=current;
            }
            else
            {
                res-=current;
            }
            prev=current;
        }
        return res;
    }
}
