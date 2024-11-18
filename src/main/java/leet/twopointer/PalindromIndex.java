package leet.twopointer;

public class PalindromIndex {

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalidrom(s, left + 1, right)) {
                    return left;
                }
                if (isPalidrom(s, left, right - 1)) {
                    return right;
                }
                return -1;
            }
            left++;
            right--;
        }
        return -1;
    }

    private static boolean isPalidrom(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromeIndex("aaab"));  // Output: 3
        System.out.println(palindromeIndex("baa"));   // Output: 0
        System.out.println(palindromeIndex("abc"));   // Output: -1
        System.out.println(palindromeIndex("racecar")); // Output: -1 (already palindrome)
    }
}




//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//import org.apache.commons.math.stat.StatUtils;
//
//public class Solution {
//
//    // provided
//    public static Map<Integer, Map<String, Integer>> getFlights(int startDay, int endDay) {
//        //   ...
//        //
//        // example:
//        // getFlights(3, 8)
//        // output ->
//        //    {
//        //       4: {"price": 300}, # eg. day 4 has a price of 300
//        //       3: {"price": 100},
//        //       ...
//        //       8: {"price": 100}
//        //   }
//        //
//        // there are many fields in each entry, only "price" is used in this problem
//    }
//
//    public static Map<String, Map<String, Integer>> getCheapestFlights(int dayRange, int startDay, int endDay) {
//        /* Enter your code here. */
//        //presever all of the cheapest flight per day
//
//        // 1 - approach
//        // 3 <-> 8
//        // iter from startDATE, jump dayRange
//        // 3 - 5  till thata starting + 3 <= 8 /
//
//        // 3 - 5  ma
//        // 4 - 6
//
//        // Map<Integer, Map<String, Integer>> flightDetail = getFlights(startDay, endDay);
//        //O(n+(m*n))
//
//        // []
//
//
//        // Map<Integer, Map<String, Integer>> flightDetail = getFlights(startingPoint, endingDate);
//
//        Map<String, Map<String, Integer>> chepeastFlightPerDay = new HashMap();
//        int startingPoint = startDay;
//        while((startingPoint + dayRange -1) <= endDay) {
//            int endingDate = startingPoint + dayRange -1 ;
//            Map<Integer, Map<String, Integer>> flightDetail = getFlights(startingPoint, endingDate);
//
//            Map<String,Integer> chepeastPerDurationOfDay = findTheChepeast(flightDetail);
//            String key  = startingPoint + "-" +endingDate;
//            chepeastFlightPerDay.put(key, chepeastPerDurationOfDay);
//            startingPoint++;
//        }
//
//        return chepeastFlightPerDay;
//    }
//
//    // {"day":3,"price":100}
//    private static Map<String,Integer> findTheChepeast(Map<Integer,Map<String, Integer>> prices) {
//        int chepestDay = -1;
//        int chepestPrice = Integer.MAX_VALUE;
//        for (Integer day : prices.keySet()) {
//            Map<String,Integer> priceDetail = prices.get(day);
//            int price = priceDetail.get("price");
//            if(price<chepestPrice){
//                chepestPrice = price;
//                 chepestDay = day;
//            }
//        }
//        Map<String,Integer> chepeast =  prices.get(chepestDay);
//
//        //{"price": 300}
//        // {"price": 100}
//        chepeast.put("day", chepestDay);
//        return chepeast;
//    }
//}