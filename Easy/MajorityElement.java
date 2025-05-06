import java.util.Hashtable;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Hashtable<Integer, Integer> hmap = new Hashtable<Integer, Integer>();

        int majorElementLimit = (nums.length)/2; 

        for(int i = 0; i< nums.length; i++){

            Integer c = hmap.get(nums[i]);

            if (hmap.get(nums[i]) == null) {
                hmap.put(nums[i], 1);
                if(1>majorElementLimit){
                    return nums[i];
                }
            }else {
                
                hmap.put(nums[i], ++c);
                if(c>majorElementLimit){
                    return nums[i];
                }
            }

        }
        return 0;
    }

    /**
    Arrays.sort(nums);
    int n = nums.length;
    return nums[n/2];
     */
    
}
