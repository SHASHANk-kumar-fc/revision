class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int sum=0,maxL=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                maxL=Math.max(maxL,i-map.get(sum-k));
            }if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxL;
    }
}