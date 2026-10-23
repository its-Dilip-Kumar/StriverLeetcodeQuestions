import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);              // prefix[-1] = 0, ek baar "dekha gaya"
        int prefixsum = 0;
        int count = 0;

        for (int num : nums) {
            prefixsum += num;

            // kitne pehle wale prefix sums == prefixsum - k ?
            count += map.getOrDefault(prefixsum - k, 0);

            // current prefix sum ki frequency badhao
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        return count;
    }
}