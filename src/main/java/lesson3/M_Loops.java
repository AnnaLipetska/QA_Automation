package main.java.lesson3;

public class M_Loops {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }//for loop replaceable with enhanced for - Java for-each Loop (Enhanced for Loop)
        //Ctrl + space, choose for
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int el: arr) {
            System.out.println(el); // Возвращает каждый i-ый элемент, но можем использовать только для чтения,
            // заменять его не можем.
        }
        //
        int k = 6;
        while (k >= 0){
            k--;
            System.out.println("Hello");
        }
        //
        int m = 4;
        do {
            m--;
            System.out.println("do while");
        } while (m >=1);
    }
}
