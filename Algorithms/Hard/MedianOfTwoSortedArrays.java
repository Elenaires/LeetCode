/* O(m+nlog(m+n)) - treat nums1 and nums2 as heaps. Repeatedly remove 
* smallest element from both heaps as a way to merge both sorted arrays
*/

// Inefficient!! 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int medianIndex;
        int countNums1 = nums1.length;
        int countNums2 = nums2.length;
        
        // to store result of sorted nums1 and num2
        int[] arr = new int[totalSize];
        int arrIndex = 0;
        
        while(countNums1 != 0 && countNums2 != 0)
        {
            // repeatedly remove head of smallest element from nums1 and nums2
            if(nums1[0] <= nums2[0])
            {
                arr[arrIndex] = nums1[0];
                nums1[0] = nums1[countNums1-1];
                trickleDown(nums1, 0, countNums1);
                countNums1--;
            }
            else
            {
                arr[arrIndex] = nums2[0];
                nums2[0] = nums2[countNums2-1];
                trickleDown(nums2, 0, countNums2);
                countNums2--;
            }
            arrIndex++;
        }
        
        // continue to populate arr with nums1
        // need to continue with trickle down because
        // nums1 and nums2 are no longer sorted after 
        // the removal and trickle down action 
        // for example 1,3,4,5,6 -> 3,5,4,6 (after removing 1)
        while(countNums1 != 0)
        {
            arr[arrIndex] = nums1[0];
            nums1[0] = nums1[countNums1-1];
            trickleDown(nums1, 0, countNums1);
            countNums1--;
            arrIndex++;
        }
        
        // continue to populate arr with nums2
        while(countNums2 != 0)
        {
            arr[arrIndex] = nums2[0];
            nums2[0] = nums2[countNums2-1];
            trickleDown(nums2, 0, countNums2);
            countNums2--;
            arrIndex++;
        }
        
        double result;
        if(totalSize % 2 == 0) // if even
        {
            medianIndex = totalSize / 2 - 1;  
            result = (double)(arr[medianIndex] + arr[medianIndex + 1]) / 2.0;
        }
        else // if odd
        {
            medianIndex = totalSize / 2;
            result = arr[medianIndex];
        }
        
        return result;
        
    }
    
    public void trickleDown(int[] arr, int index, int count)
    {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = leftChildIndex + 1;
        int smallIndex;
        
        if(leftChildIndex < count)
        {
            smallIndex = leftChildIndex;
            if(rightChildIndex < count)
            {
                if(arr[leftChildIndex] > arr[rightChildIndex])
                {
                    smallIndex = rightChildIndex;
                }
                if(arr[smallIndex] < arr[index])
                {
                    int temp = arr[smallIndex];
                    arr[smallIndex] = arr[index];
                    arr[index] = temp;
                    trickleDown(arr, smallIndex, count);
                }
            }
        }
        
    }
}
