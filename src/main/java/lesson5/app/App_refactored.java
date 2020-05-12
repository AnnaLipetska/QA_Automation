package main.java.lesson5.app;

public class App_refactored {
    public static void main(String[] args) {
        String s = "Vladimir";
        System.out.println("Дичь с кучей Владимиров");
    }

    public String someMethod() { // void - не прокатит, если метод ничего не возвращает, тестировать его очень тяжело
        String s = "Vladimir";
        int i = 10;
        for (int j = 0; j < i; j++) {
            s += s;
        }
        return s;
    }
    // Чтобы метод можно было протестировать он должен быть публичным (его можно было вызвать) и метод должен
    // возвращать значение. Все что печатаете в консоль - не тестируется. Тестировать можно только возвращаемое
    // значение.
}
