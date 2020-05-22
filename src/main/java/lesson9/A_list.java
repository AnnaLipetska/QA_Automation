package main.java.lesson9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class A_list {
    public static void main(String[] args) {
        // Мы умеем работать с массивами.
        int[] arr = {45, 45, 78, 89};
        // В массивах нельзя добавлять дополнительно значения, либо удалять, чтобы не осталось дырки (элемент просто
        // примет значение равное null).
        // Коллекции - более удобно работать с массивами.
        // Коллекции - это, по сути, набор классов и интерфейсов, которые позволяют работать с массивами в очень
        // удобном формате, более их структурировать и решает проблему увеличения массива.
//.....................
        Integer a = 45; // полноценный примитив
        Integer a1 = 45;
        Integer b = new Integer(45); // полноценный объект, по ссылке
        Integer d = new Integer(45); // Integer - класс-обертка над int
        // System.out.println(a == a1); // true
        // System.out.println(a == b); // false
        // System.out.println(b == d); // false
        // System.out.println(b.equals(d)); // true
//...................
        // ArrayList list = new ArrayList();
        // List<Integer> list = new ArrayList<>(); // <> можно удалить
        List<Integer> list = new ArrayList();
        // <> generic
        // Дженерики принимают только объекты
//.............................
        int arrSize = arr.length;
        int listSize = list.size();
//...........
        int first = arr[0];
        // list[0] невалидная запись
        list.add(45);
        list.add(45);
        list.add(47);
        list.add(8);
        list.add(800);
        list.remove(3); // удаляет третий элемент массива

        System.out.println("Size " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------");
        for (Integer el : list) {
            System.out.println(el);
        }
        System.out.println("***********");
        // С помощью итератора:
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("----");
            System.out.println(iterator.next());
        }
        // hasNext и Next
        // hasNext смотрит на первый элемент коллекции,возвращает true и перемещается, а в конце выдаст false, потому
        // что больше нет в коллекции больше ничего
        // Next возвращает значение текущей ячейки и итератор перемещается на следующий элемент
        // Если не вызывать iterator.next(), то цикл будет бесконечным, так как не будет перемещаться.

    }
}
