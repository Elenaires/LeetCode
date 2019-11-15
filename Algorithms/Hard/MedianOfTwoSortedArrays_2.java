// O(m+n) using merge

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int combinedLength = nums1.length + nums2.length;
        int[] mergedArray = new int[combinedLength];
        
        merge(nums1, nums2, mergedArray);
        
        int middle = combinedLength / 2;
        
        if(combinedLength % 2 == 0) {
            return (double)(mergedArray[middle-1] + mergedArray[middle]) / 2.0;
        }
        else {
            return mergedArray[middle];
        }
    }
    
    private void merge(int[] array1, int[] array2, int[] mergedArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < array1.length && j < array2.length) {
            if(array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            }
            else {
                mergedArray[k++] = array2[j++];
            }
        }
        
        while(i < array1.length) {
            mergedArray[k++] = array1[i++];
        }
        
        while(j < array2.length) {
            mergedArray[k++] = array2[j++];
        }
    }
}
