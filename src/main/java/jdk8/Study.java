package jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Study {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        Optional.ofNullable(list.get(0)).ifPresent(System.out::println);
    }
}
