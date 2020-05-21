package main.java.lesson9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B_Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(); // последние треугольные скобочки можно убирать/не убирать
        // Сейчас в основном отрезают их, раньше там тоже писали тип хранимых значений, но теперь это уже не нужно.
        // И так и так правильно, принято на разных проектах по разному
        set.add(56);
        set.add(56);
        set.add(456);
        for (Integer el: set) {
            System.out.println(el);
        }
        // Удобно, если нужно получить массив, в котором нет дублей.
        Integer[] arr = {45,46, 46, 46, 80};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr));
        for (Integer el: set1) {
            System.out.println(el); // Распечатываются не по порядку.
        }
    }
}
