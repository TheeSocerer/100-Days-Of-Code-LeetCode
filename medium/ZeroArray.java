/**
 Key Idea
Instead of applying every operation directly to nums (which would be inefficient), you:

- Use a difference array deltaArray to efficiently mark operation ranges.

- Compute a prefix sum on deltaArray to get the total number of operations at each position in the array.

- Check if the number of operations is enough to bring each element of nums to 0.
 */

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int[] deltaArray = new int[nums.length + 1];

        for(int[] sub: queries){
            deltaArray[sub[0]] += 1;
            deltaArray[sub[1]+1] -= 1;
        }

        int[] prefixSum = new int[nums.length];
        int operations = 0;

        for (int i =0; i<nums.length; i++){
            operations += deltaArray[i];
            prefixSum[i] += operations;
            
        }
        for (int i =0; i<nums.length; i++){
            if(prefixSum[i] < nums[i] ){
                return false;
            }
        }
        return true;
    }

}