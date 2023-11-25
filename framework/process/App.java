package models;

public class App {

    public static void main(String[] args) {
        FileProcess file = new FileProcess("models.exemple", "MyClassX");
        file.generate(1);
    }
}
