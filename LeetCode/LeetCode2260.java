package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode2260 {
    public static void main(String[] args) {
        int[] cards = {95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6};
        System.out.println(minimumCardPickup(cards));
    }

    public static int minimumCardPickup(int[] cards) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < cards.length; i++)  set.add(cards[i]);
        if((set.size() == cards.length))  return -1;

        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < cards.length; i++)   {
            if(map.containsKey(cards[i]))  res = Math.min(res, i - map.get(cards[i]) + 1);
            map.put(cards[i], i);
        }
        return res == Integer.MAX_VALUE ? -1: res;
    }
}
