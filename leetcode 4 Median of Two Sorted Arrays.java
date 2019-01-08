//leetcode 4 Median of Two Sorted Arrays

//O(log(min(m,n)))
//space: O(1)

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
        	return findMedianSortedArrays(nums2, nums1); //取两数组中的最小值，达到操作最简化
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0; //num1左有几个元素
        int cut2 = 0; //num2左有几个元素
        int cutL = 0;
        int cutR = nums1.length;

        //(cutL, cutR) 设定num1的二分搜索范围控制
        //L1 > R2 cut1 << (cutL, cut1 - 1)
        //L2 > R1 cut2 >> (cut1 + 1, cutR)
        while(cut1 <= nums1.length) {
        	cut1 = (cutR - cutL) / 2 + cutL;
        	cut2 = len / 2 - cut1;
        	// num1 3  5  8  9 num1不用切 |放在最右边 用MAX_VALUE表示
            //         L1 R1
        	// num2 1  2
        	double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1]; //左边最大值换成index要减1
        	double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
        	double R1 = (cut1 == 0) ? Integer.MAX_VALUE : nums1[cut1];
        	double R2 = (cut2 == 0) ? Integer.MAX_VALUE : nums2[cut2];
        	if(L1 > R2) {
        		cutR = cut1 - 1; 
        	} else if(L2 > R1) {
        		cutL = cut1 + 1;
        	} else {
        		if(len % 2 == 0) { // 偶数
        			L1 = L1 > L2 ? L1 : L2;
        			R1 = R1 < R2 ? R1 : R2;
        			return (L1 + R1) / 2;
         		} else { //奇数总在R1和R2中取最小值
         			R1 = (R1 < R2) ? R1 : R2;
         			return R1；
         		}
        	}
        }
        return -1;
    }
}