package com.source;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class main {
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> q1 = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return hashmap.get(a) - hashmap.get(b);
            }
        });
        for(Integer key: hashmap.keySet()){
            if(q1.size() < k){
                q1.add(key);
            }else{
                if(hashmap.get(key) > hashmap.get(q1.peek())){
                    q1.remove();
                    q1.add(key);
                }
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = q1.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = topKFrequent(nums, k);
    }
}
