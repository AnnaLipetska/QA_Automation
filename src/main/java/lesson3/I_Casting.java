package main.java.lesson3;

public class I_Casting {
    public static void main(String[] args) {
        System.out.println(2/3); // 0
        System.out.println(2f/3f); // 0.6666667
        System.out.println((float)2/3); // 0.6666667
        System.out.println(2/(float)3); // 0.6666667
        System.out.println(2.0/3);

        int a = 10;
        long b = a;
        System.out.println(b);
        //int c = b; Ошибка уровня компиляции
        int c = (int)b;
        long d = 222222222222L;
        int e = (int)d;
        System.out.println(e);
        //ValueOf еще можно использовать
    }
}
