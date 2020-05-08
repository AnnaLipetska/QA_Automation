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

}

