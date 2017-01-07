public class Solution {
    public int compareVersion(String version1, String version2) {
       int val1, val2;
		int idx1 = 0, idx2 = 0;
		//逐个level的比较大小
		while(idx1 < version1.length() || idx2 < version2.length()){
			//一趟大循环比较一个level的数值，因此在开始的时候要将本level的数值清零，
			//此处先进行version1的某level的数值获取
			val1 = 0;
			while(idx1 < version1.length()){
				//如果遇到点，先例行将index加一，然后结束本次循环，此时说明点前面的这个level的数值已经得到，可以参加比较
				if(version1.charAt(idx1) == '.'){
					++idx1;
					break;
				}else{
					//累加得到本level的数值
					val1 = val1 * 10 + (version1.charAt(idx1) - '0');
					idx1++;
				}
			}
			//当上面的循环遍历遇到点时循环结束，即version1的一个level遍历完了，之后对version2做同样的工作
			val2 = 0;
			while(idx2 < version2.length()){
				if(version2.charAt(idx2) == '.'){
					++idx2;
					break;
				}else{
					val2 = val2 * 10 + (version2.charAt(idx2) - '0');
					idx2++;
				}
			}
			//在相同level下，此时已经获取完了两个version的在该level的数值，开始比较
			if(val1 > val2)
				return 1;
			if(val1 < val2)
				return -1;
		}
		return 0;
    }
    //第二种做法，也对，但是会超时
    public int compareVersion2(String version1, String version2) {
        int index1 = 0;
        int firstLevel_1 = 0;
        int secondLevel_1 = 0;
        int levelChange_1 = 0;
        int version1Value[] = {0};
        
        int index2 = 0;
        int firstLevel_2 = 0;
        int secondLevel_2 = 0;
        int levelChange_2 = 0;
        int version2Value[] = {0};
        //判定合法性
        if(version1.charAt(index1) < '0' || 
        		version1.charAt(index1) > '9' || 
        		version2.charAt(index2) < '0' || 
        		version2.charAt(index2) > '9'){
        	System.out.println("version error!");
        	return -2;
        }
        for(; (index1 < version1.length()) && (index2 < version2.length()); index1++,index2++){
        	//version1
        	//如果遇到小数点说明level改变一次
        	if(version1.charAt(index1) == '.'){
        		levelChange_1++;
        	}else{
        		//最初的levelChange为0，level最初为first，因此当levelChange为偶数时是firstlevel
            	version1Value[levelChange_1] = version1Value[levelChange_1] * 10 + (version1.charAt(index1) - '0');
        	}
        	//version2
        	//如果遇到小数点说明level改变一次
        	if(version2.charAt(index2) == '.'){
        		levelChange_2++;
        	}else{
        		//最初的levelChange为0，level最初为first，因此当levelChange为偶数时是firstlevel
        		version2Value[levelChange_2] = version2Value[levelChange_2] * 10 + (version2.charAt(index2) - '0');
        	}
        }
        
        if(index1 < version1.length() || index2 < version2.length()){
        	if(index1 < version1.length()){
        		while(index1 < version1.length()){
        			if(version1.charAt(index1) == '.'){
        				levelChange_1++;
            		}else if(version1.charAt(index1) < '9' && version1.charAt(index1) > '0'){
            			version1Value[levelChange_1] = version1Value[levelChange_1] * 10 + (version1.charAt(index1) - '0');
            		}
        		}
        	}
        	
        	if(index2 < version2.length()){
        		while(index2 < version2.length()){
        			if(version2.charAt(index2) == '.'){
        				levelChange_2++;
            		}else if(version2.charAt(index2) < '9' && version2.charAt(index2) > '0'){
            			version2Value[levelChange_2] = version2Value[levelChange_2] * 10 + (version2.charAt(index2) - '0');
            		}
        		}
        	}
        }
        //比较大小
        for(index1 = 0, index2 = 0; index1 < version1Value.length && index2 < version2Value.length; index1++, index2++){
        	if(version1Value[index1] > version2Value[index2]){
        		return 1;
        	}else if(version1Value[index1] < version2Value[index2]){
        		return -1;
        	}else{
        		//如果两个version的同一level相等，看它们的下一个level
        		continue;
        	}
        }
        //如此遍历完了仍没有返回说明version1和version2的前面共有的几个level值相同，
        //如果它们拥有的level数量相同，那么说明这两个version完全相同
        //如果它们拥有的level数量不同，那么对于level多的version来说，可以将多出来的level值与零相比，大于零则说明大
        if(version1Value.length == version2Value.length){
        	return 0;
        }else{
        	if(version1Value.length > version2Value.length){
        		//verison1的level多
        		while(index1 < version1Value.length){
        			if(version1Value[index1] > 0){
            			return 1;
            		}else{
            			continue;
            		}
        		}
        		//这次遍历完了之后还没有返回值，就说明相等
        		return 0;
        	}else{
        		//version2的level多
        		while(index2 < version2Value.length){
        			if(version2Value[index2] > 0){
            			return -1;
            		}else{
            			continue;
            		}
        		}
        		//这次遍历完了之后还没有返回值，就说明相等
        		return 0;
        	}
        }
    }
}
