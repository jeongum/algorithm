import java.util.Arrays;

public class LT_26_RemoveDuplicatesfromSortedArray_java {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        LT_26_RemoveDuplicatesfromSortedArray_java solver =
                new LT_26_RemoveDuplicatesfromSortedArray_java();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4}; // The expected answer with correct length

        int k = solver.removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
