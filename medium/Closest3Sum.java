import java.util.*;
/**
 * Closest3Sum
 */
public class Closest3Sum {

    public int threeSumClosest(int[] nums, int target) {
        int cloest = 0;
        int min = Integer.MAX_VALUE;
        //Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0;i < nums.length - 2;i++){
            int l = i+1,r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                int delta = target - sum;
                min = Math.abs(delta) > Math.abs(min) ? min:delta;
                if(sum < target){
                    l++;
                } else if(sum > target){
                    r--;
                } else{
                    return sum;
                }
            }
        }
        //System.out.println(min);
        return target - min;
    }
    public static void main(String[] args) {
        System.out.println(new Closest3Sum().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }


}