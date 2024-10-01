package leet;

public class LongestCommonSubsequence {

    private static String lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        StringBuilder lcsString = new StringBuilder();
        while (m > 0 && n > 0) {
            if (a.charAt(m - 1) == b.charAt(n - 1)) {
                lcsString.append(a.charAt(m - 1));
                m--;
                n--;
            } else if (lcs[m - 1][n] > lcs[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        return lcsString.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(lcs("xkykzpw", "zxvvyzw"));
    }
}
