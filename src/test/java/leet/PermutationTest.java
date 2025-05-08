package leet;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import leet.backtrack.Permutation;

public class PermutationTest {

    private Permutation permutation;

    @Before
    public void prepare() {
        permutation = new Permutation();
    }

    @Test
    public void permute() {
        int[] nums = {1, 2, 3};
//        List<List<Integer>> result = List.of(List.of(1, 2, 3), List.of(1, 3, 2)
//                , List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
        List<List<Integer>> permutations = permutation.permute(nums);
        System.out.println(permutations);
    }
}


class asdf {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b  = 100;

        System.out.println(a == b);

        Integer x = 200;
        Integer y  = 200;
        System.out.println(x == y);

        System.out.println(isAllowedOrigin(" 998352.cbo-crm.realworks.nl", List.of("*.realworks.nl")));
    }


    private static boolean isAllowedOrigin(String originHost, List<String> allowedOrigins) {
        if (originHost == null) {
            return false;
        }

        return allowedOrigins.stream().anyMatch(allowedOrigin -> {
            if (allowedOrigin.startsWith("*.")) {
                // Handle wildcard subdomains
                String domain = allowedOrigin.substring(1); // Remove leading '*'
                return originHost.endsWith(domain);
            }
            // Handle exact match
            return allowedOrigin.equalsIgnoreCase(originHost);
        });
    }
}