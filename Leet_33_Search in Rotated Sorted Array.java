public class Solution {
    public int search(int[] A, int target) {  
        int len = A.length;  
        if (len == 0) return -1;  
        return binarySearch(A, 0, len-1, target);  
    }  
      
    public int binarySearch(int[] A, int left, int right, int target) {  
        if (left > right) return -1;  
          
        int mid = (left + right) / 2;  
        if (A[left] == target) return left;  
        if (A[mid] == target) return mid;  
        if (A[right] == target) return right;  
          
        //图示情况一  
        if (A[left] < A[right]) {   
            if (target < A[left] || target > A[right]) {    //target不在数组范围内  
                return -1;  
            } else if (target < A[mid]) {                   //target在左边  
                return binarySearch(A, left+1, mid-1, target);  
            } else {                                        //target在右边  
                return binarySearch(A, mid+1, right-1, target);  
            }  
        }   
        //图示情况二  
        else if (A[left] < A[mid]) {   
            if (target > A[left] && target < A[mid]) {      //target在左边  
                return binarySearch(A, left+1, mid-1, target);  
            } else {                                        //target在右边  
                return binarySearch(A, mid+1, right-1, target);  
            }  
        }   
        //图示情况三  
        else {   
            if (target > A[mid] && target < A[right]) {     //target在右边  
                return binarySearch(A, mid+1, right-1, target);  
            } else{                                         //target在左边  
                return binarySearch(A, left+1, mid-1, target);  
            }  
        }  
    }
}
