package main.java.lesson5.inheritance;

public class Exceptions {
    public static void main(String[] args) {
        a();
    }

    public static void a() {
        try {
            b();
        } catch (Exception e) {
            System.out.println("Exception was caught");
        }
        System.out.println("method");
    }

/*    public static void b() {
        // System.out.println(" B method - File was read");
        // Обработка исключений
        // int f = 7 / 0; // Ошибка

        // Первый способ обработки исключений
        try { // В блоке try должно быть по минимуму информации
            int a = 7 / 0; // Нормально отрабатывает, не вылетает
            System.out.println("B method - file was read"); // После поломки ничего не исполняется
            System.out.println("B method - file was read"); // Управление передается в блок catch
        } catch (Exception e) {
            System.out.println("File not found");
        }*/

    // Второй способ - не обрабатывать внутри себя, а прокидывать наружу
    public static void b() throws Exception {
        System.out.println("B method - file was read");
        System.out.println("B method - file was read");
        int a = 7 / 0;
        System.out.println("After Exception");
    }
}
