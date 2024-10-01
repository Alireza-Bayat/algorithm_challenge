package leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
*/
public class IntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = Map.ofEntries(
                entry(1, "I"),
                entry(5, "V"),
                entry(10, "X"),
                entry(50, "L"),
                entry(100, "C"),
                entry(500, "D"),
                entry(1000, "M")
        );

        if (num + 1 == 5)
            return "IV";
        if (num + 1 == 10)
            return "IX";
        if (num+ 10 ==50 )
            return "XL";
        if (num+ 10 ==100 )
            return "XC";
        if (num+ 100 ==500 )
            return "CD";
        if (num+ 100 ==1000 )
            return "CM";




        return "";
    }


    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> counterList = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            counterList.add(0);
        }

        for (Integer integer : arr) {
            counterList.set(integer, counterList.get(integer) + 1);
        }

        return counterList;
    }
    public static void main(String[] args) {
        System.out.println("63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33".replaceAll(" ",","));
        List<Integer> integers = countingSort(List.of(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33));
        System.out.println("done");
    }
}
