package util;

import java.util.List;

public class ConsolePrinter {
    public static <T> boolean printList(List<T> list, String emptyPrint) {
        if(list.isEmpty()) {
            System.out.println(emptyPrint);
        }
        return false;
    }

    public static <T> void showList(List<T> list, String header){
        System.out.println(header);
        list.forEach(System.out::println);
    }
}
