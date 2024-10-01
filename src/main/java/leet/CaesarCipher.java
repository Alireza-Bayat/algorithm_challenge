package leet;

public class CaesarCipher {

    public static String caesarCipher(String s, int k) {
        StringBuilder result = new StringBuilder();
        k = k % 26;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int asciiValue = (int) c;
            if (isUpperCase(asciiValue)) {
                asciiValue += k;
                if (!isUpperCase(asciiValue)) {
                    asciiValue -= 26; // wrap back to 'A-Z'
                }
            } else if (isLowerCase(asciiValue)) {
                asciiValue += k;
                if (!isLowerCase(asciiValue)) {
                    asciiValue -= 26; // wrap back to 'a-z'
                }
            }
            result.append((char) asciiValue);
        }

        return result.toString();
    }

    private static boolean isLowerCase(int asciiCode) {
        if (asciiCode >= 97 && asciiCode <= 122) {
            return true;
        }
        return false;
    }

    private static boolean isUpperCase(int asciiCode) {
        if (asciiCode >= 65 && asciiCode <= 90) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(caesarCipher("Hello_World!", 4));

        //Lipps_Asvph!
    }
}
