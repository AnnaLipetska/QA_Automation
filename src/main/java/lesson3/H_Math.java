package main.java.lesson3;

public class H_Math {
    public static void main(String[] args) {
        int a = 10;
        int b = 40 + 50 - 10 * 80 / 70 * (40 +80);
        int c = b * a;
        int d = 5 % 2; // 1
        a = a + 1; // 11
        System.out.println(a);
        a++; // 12
        System.out.println(a);
        a--; // a = a - 1;
        //a = a + 10;
        a += 10;
        a -= 10;
        a *= 10;
        a /= 10;
    }
}
