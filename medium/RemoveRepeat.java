import java.util.Arrays;

/**
 * RemoveRepeat
 */
public class RemoveRepeat {

    // public static int removeDuplicates(int[] nums) {
    //     int index = 0;
    //     int prstCnt = 0;
    //     int len = nums.length;
    //     while (index < len) {
    //         if (index == 0 || nums[index] == nums[index - 1]) {
    //             prstCnt = prstCnt + 1;
    //             if (prstCnt <= 2) {
    //                 index = index + 1;
    //             } else {
    //                 // 移位
    //                 shift(nums, index, len);
    //                 len--;
    //             }
    //         } else {
    //             prstCnt = 1;
    //             index++;
    //         }
    //     }
    //     return len;
    // }

    // public static int removeDuplicates(int[] nums) {
    //     int index = 1;
    //     int pointer = 1;
    //     int preNum = nums[0];
    //     int prstCnt = 1;
    //     while(index < nums.length){
    //         if(nums[index] == preNum ) {
    //             prstCnt++;
    //             if(prstCnt > 2) {
    //                 while( index < nums.length && nums[index] == preNum){
    //                     index++;
    //                 }
    //                 continue;
    //             }
    //         } else {
    //             preNum = nums[index];
    //             prstCnt = 1;
    //         }
    //         nums[pointer] = nums[index];
    //         pointer++;
    //         index++;
    //     }
    //     return pointer;
    // }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num : nums){
            if(i < 2 || num != nums[i - 2])
                nums[i++] = num;
        }
        return i;
    }



    static void shift(int[] nums, int start, int len) {
        for (int i = start; i < len - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public static void main(String[] args) {
        int[] tmp = {0, 0, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(tmp));
        System.out.println(Arrays.toString(tmp));
    }

}