package algoExpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroupAnagramTest {

    private GroupAnagram groupAnagram;

    @Before
    public void setup() {
        groupAnagram = new GroupAnagram();
    }

    @Test
    public void groupAnagrams() {
        List<List<String>> expectedOutput = List.of(Arrays.asList("asd", "sad", "dsa"), Arrays.asList("ooh", "oho", "hoo"));
        List<List<String>> actual = groupAnagram.groupAnagrams(List.of("asd", "ooh", "sad", "oho", "dsa", "hoo"));
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void groupAnagrams_null() {
        List<List<String>> lists = groupAnagram.groupAnagrams(new ArrayList<>());
        Assert.assertEquals(new ArrayList<>(), lists);
    }

    private void printAnagramList(List<List<String>> arrayLists) {
        for (List<String> arrayList : arrayLists) {
            for (String s : arrayList) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }
}