package main.java.lesson13;

import java.util.HashSet;
import java.util.Set;

public class Random {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        /*List<WebElements> el = driver.findElementsBy();
        * int max = el.size();
        * el.get(rand);*/
        int max = 10;
        int min = 5;
        for (int i = 0; i < 1000000; i++) {
            int rand = (int) (Math.random() * (max + 1 - min) + min);
            set.add(rand);
        }
        for (Integer el : set) System.out.println(el);
    }
}
