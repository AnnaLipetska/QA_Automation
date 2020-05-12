package main.java.lesson5.app;

public class Server { // Будет выполнять очень примитивную логику
    // Допустим у нас будет некая база данных
    private String[] arr = {"Vova", "Andrey", "Alexandr"}; // База данных пользователей

    // Метод который будет возовращать список пользователей
    // в виде одной строки, разделенных через запятую:
    public String getUsers() {
        String result = "";
        for (int i = 0; i < this.arr.length; i++) {
            //result += this.arr[i] + ", "; // в таком случае запятая будет и после последнего значения
            result += this.arr[i] + (i < this.arr.length - 1 ? ", " : "");
        }
        return result;
    }

    // Создаем метод чтобы протестировать с помощью data providing
    public String getStatus(int age) {
        if (age <= 0) { // Дописали это условие, чтобы не было бага
            return "Not valid input";
        } else if (/*age < 18*/ /*age > 0 &&*/ age < 18) { // Исправили ошибку в коде, но так не помогло до конца
            // пришлось выше одно условие дописать, а тут обратно вернуть
            return "Student";
        } else if (age < 60) {
            return "Worker";
        } else if (age /*<*/ <= 90) { // Исправили ошибку в коде
            return "Pensioner";
        } else {
            return "Not valid input";
        }
    }
}

