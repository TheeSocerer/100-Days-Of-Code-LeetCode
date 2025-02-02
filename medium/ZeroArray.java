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