package jdk21;

import java.util.Arrays;
import java.util.List;

//import static java.lang.StringTemplate.STR;

public class Sample21 {

    public static void main(String[] args) {
        String caseString = "YES";
        switch (caseString) {
            case "yes", "YES", "yeah" -> System.out.println("yes");
            default -> System.out.println("no");
        }

//        String template = "name: ";
//        String msg = STR."Template variable is \{template}";
//        System.out.println(msg);

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Integer first = list.getFirst();
//        Integer last = list.getLast();
//        System.out.println("FIRST ELEMENT: " + first + " LAST ELEMENT: " + last);
//        list.reversed();
//        System.out.println("LIST REVERSED");
//        System.out.println("FIRST ELEMENT: " + list.getFirst() + " LAST ELEMENT: " + list.getLast());


    }
}
