package main.java.lesson3;

public class A_Primitive_Byte {
    public static void main(String[] args) {
        byte a = 20;
        byte b = 127;
        //byte c = 128; Ошибка уровня компиляции.
        // Переменные всегда именуйте с маленькой буквы
        // Давать реальные имена
        byte age = 40;
        byte ageOfUser;
        // byte Aa; bad practice
        byte c;
        c = 50;
        System.out.println(c);
        c = 80;
        System.out.println(c);
        // Shift + Alt + arrow - двигает строчку
        byte d = 50;
        byte e = 'd'; // ascii 100
        System.out.println(e);
        // byte e = 'ы'; Ошибка. Для кириллицы значения ascii больше чем 127
    }
}
