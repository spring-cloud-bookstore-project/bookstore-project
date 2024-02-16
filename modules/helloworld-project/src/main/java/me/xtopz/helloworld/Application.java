package me.xtopz.helloworld;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello, " + System.getenv().getOrDefault("HELLOWORLD_USER_NAME", "unknown user") + "!");
    }

}
