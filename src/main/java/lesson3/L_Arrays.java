package main.java.lesson3;

public class L_Arrays {
    public static void main(String[] args) {
        int[] a = {10, 20, 30}; //Java-style
        int b[] = {10, 20, 30}; //C-style
        int c[] = new int[5];
        char[] ch = {'c', 's'};
        String[] str = {"Hello", "world"};

        int[] arr = {2, 4, 6, 8};
        System.out.println(arr[0]); // нумерация с нуля
        arr[0] = 10;
        System.out.println(arr[0]);

        // System.out.println(arr); // Это ссылочный объект, поэтому сам список не распечатывается, распечатывается ссылка

        System.out.println(arr.length);
        System.out.println(arr[arr.length-1]);
    }
}
