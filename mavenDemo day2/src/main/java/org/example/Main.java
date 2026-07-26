package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Niraj Chauhan");

        SayBye controller = new SayBye();
        String b1 = controller.printBye();

        System.out.println(b1);
    }
}