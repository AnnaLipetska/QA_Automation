package test.java.lesson9;

public class A_First {
    public static void main(String[] args) {
        // Задание - избавиться от лишних символов, вывести только цифры.
        String tel = "+38(050) asdas1-135-45 45";
        // Вариант 1:
        String res = tel
                .replace("+", "")
                .replace("(", "")
                .replace(")", "")
                .replace("-", "")
                .replace(" ", "");
        // Данный код не удалил буквы, их нужно тоже дописать.
        // Это не самый удобный вариант. Каждый символ перечисляем.
        // И если, например, нужно вырезать все буквы, а их в алфавите оч. много...
        // String res2 = tel.replace("\D", ""); //Ошибка, в методе replace() можно использовать только
        // конкретные символы.
        String res2 = tel.replace("\\D", ""); // Не удалило ничего.
        //........
        // Вариант 2 - с помощью регулярных выражений:
        String res3 = tel.replaceAll("[a-zA-Z()+ -]", "");
        String res4 = tel.replaceAll("\\D", "");
        String res5 = tel.replaceAll("[\\D]", "");
        // Зачем \\?
        // В регулярном выражении \ - управляющий символ
        // Например, \D означает все нецифровые символы
        // Первый бэкслэш экранирует второй бэкслэш, а второй нужен для экранирования символа - в данном случае буквы D.
        // Регулярные выражения позволяют взять строку, распарсить.
        // Разница между методами replace() и replaceAll() - в первом случае мы просто используем конкретные символы, а
        // во втором используются регулярные выражения.
        //...........
        // Вариант 3 - с помощью отрицания в регулярных выражениях:
        String res6 = tel.replaceAll("[^0-9]", "");
        String res7 = tel.replaceAll("[^\\d]", "");
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
    }
}