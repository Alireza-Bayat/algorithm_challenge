package leet.stack;

import java.util.Stack;

/**
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
 * <p>
 * The rules of a Unix-style file system are as follows:
 * <p>
 * A single period '.' represents the current directory.
 * A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
 * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
 * <p>
 * The simplified canonical path should follow these rules:
 * <p>
 * The path must start with a single slash '/'.
 * Directories within the path must be separated by exactly one slash '/'.
 * The path must not end with a slash '/', unless it is the root directory.
 * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
 * <p>
 * Return the simplified canonical path.
 * <p>
 * Input: path = "/.../a/../b/c/../d/./"
 * Output: "/.../b/d"
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> directories = new Stack<>();
        String[] split = path.split("/");

        int isLastDoubleDot = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            String directory = split[i];
            if (directory == null || directory.isEmpty() || directory.equals(".")) {
                continue;
            }

            if (directory.equals("..")) {
                isLastDoubleDot++;
            } else {
                if (isLastDoubleDot > 0) {
                    isLastDoubleDot--;
                    continue;
                }
                directories.push(directory);
                directories.push("/");
            }
        }

        StringBuilder canonical = new StringBuilder();
        while (!directories.isEmpty()) {
            canonical.append(directories.pop());
        }

        if (canonical.isEmpty()) return "/";
        return canonical.toString();
    }

}
