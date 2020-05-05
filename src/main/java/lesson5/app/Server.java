package main.java.lesson5.app;

public class Server {
    private String[] arr = {"Vova", "Andrey", "Alexander"};

    public String getusers() {
        String result;
        for (int i = 0; i < this.arr.length; i++) {
            result += this.arr[i] + "";
        }
        //Escape Sequence	Description
        //\b	Insert a backspace in the text at this point.
    }
}
