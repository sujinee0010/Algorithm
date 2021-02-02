package Complete.NDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MakeDduck {
    public static int solution(int n ,int m , int[] nums){
        Arrays.sort(nums);
        int result = 0;
        int start = 0;
        int end =nums[nums.length-1];

        while(start<=end) {
            int sum = 0;
            int mid = (start+end)/2;
            System.out.println(start+" , "+mid  +","+end );
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > mid)
                    sum += nums[i] - mid;
            }
            if (sum < m)
                end = mid -1;
            else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
    public static void main(String args[]){
        System.out.println(solution(4,6,new int[]{19,15,10,17}));
    }
}
