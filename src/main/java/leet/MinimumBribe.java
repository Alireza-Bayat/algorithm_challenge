package leet;

import java.util.List;

public class MinimumBribe {


    public static void minimumBribes(List<Integer> q) {
//        int bribe = 0;
//
//        for (int i = 0; i < q.size() - 1; i++) {
//            int a = q.get(i);
//            if (a == i + 1) {
//                continue;
//            }
//            int changedPosition = a - (i + 1);
//            if (changedPosition < 0) {
//                continue;
//            }
//            if (changedPosition > 2) {
//                System.out.println("Too chaotic");
//                return;
//            }
//            bribe += changedPosition;
//
//        }
//        System.out.println(bribe);

        int bribes = 0;

        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {
        minimumBribes(List.of(1 ,2 ,5 ,3 ,7 ,8 ,6, 4));
    }
}
